package com.accolite.au;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class Call implements Call_Interface{
	String dailedName = "";
	LocalDate dailedDate = null;
	LocalTime dailedTime = null;
	long callDuration = 0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Contact contact = new Contact();
	
	Call(){}

	Call(String name, long duration){
		this.dailedName = name;
		this.dailedDate = LocalDate.now();
		this.dailedTime = LocalTime.now();
		this.callDuration = duration;
	}

	public void dial(){
		String temp = null;
		try {
			System.out.println("Enter Phone Number: ");
			temp = br.readLine();
			BigInteger phn_no;
			if(temp.length() != 10) {
				System.out.println("Enter Correct Phone Number\n");
			}
			else {
				phn_no = new BigInteger(temp);
				if(phn_no.compareTo(Mobile.UserMobile) == 0) {
					System.out.println("Can't call to your own number\n");
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Enter Valid Phone Number\n");
			e.printStackTrace();
		}
		makeCall(temp);
	}
	
	public void makeCall(String num) {
		String temp = new String("");
		System.out.println("Connecting...");
		for(int i = 0;i<1000*1000*1000;i++);
		System.out.println("Connected");
		long startTime = System.nanoTime();
		while(!(temp.equals("cancel"))) {
			System.out.println("Press cancel to disconnect the call\n");
			try {
				temp =	br.readLine();
			} catch (NumberFormatException | IOException e) {
				System.out.println("Error occured\n");
				break;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Time Elapsed\n" + (endTime-startTime)/1000000000 + "seconds");
		System.out.println("Disconnected\n");
		Mobile.Tele_arr.add(new Call(num,(endTime-startTime)/1000000000 ));

	}

	public void connectCall(String name) {
		String temp = new String("");
		if(contact.searchContact(name) == null){
			System.out.println("This contact is not available\n");
			return;
		}
		System.out.println("Connecting...");
		for(int i = 0;i<1000*1000*1000;i++);
		System.out.println("Connected");
		long startTime = System.nanoTime();
		while(!(temp.equals("cancel"))) {
			System.out.println("Press cancel to disconnect the call\n");
			try {
				temp =	br.readLine();
			} catch (NumberFormatException | IOException e) {
				System.out.println("Error occured\n");
				break;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Time Elapsed\n" + (endTime-startTime)/1000000000 + "seconds");
		System.out.println("Disconnected\n");
		Mobile.Tele_arr.add(new Call(name,(endTime-startTime)/1000000000 ));
	}

	public void callHistory() {
		System.out.println(Mobile.Tele_arr);
	}
	
	public String toString() {
		return (dailedName + "\nDate: " + dailedDate + "\nTime: " + dailedTime + "\nDuration: " + callDuration + "\n\n");
	}
}


