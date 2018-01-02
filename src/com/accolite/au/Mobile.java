package com.accolite.au;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Mobile {
	static ArrayList<Contact> contact_arr = new ArrayList<Contact>();
	static ArrayList<Call> Tele_arr = new ArrayList<Call>();
	static String UserName;	
	static BigInteger UserMobile;
	static String UserMail;
	
	static boolean validateEmail(String email) {
		String pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern, java.util.regex.Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = p.matcher(email);
		return matcher.matches();
	}

	static void initialize_userData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		UserName = sc.nextLine();
		System.out.println("Enter your phone number: ");
		try {
			String temp = sc.nextLine();
			if(temp.length()!=10) {
				System.out.println("Enter correct phone number\n");
				System.exit(1);
			}
			UserMobile = new BigInteger(temp);
		}catch(Exception e) {
			System.out.println("Enter valid phone number\n");
			System.exit(1);
		}
		do{
			System.out.println("Enter your Email ID: ");
			UserMail = new String(sc.nextLine());
		}
		while(!(validateEmail(UserMail)));
		System.out.println("Hello " + UserName + "\nWelcome to Telephone Services\n\n");
		//sc.close();
	}
	
	public static void main(String[] args) {
		Contact contact = new Contact();
		Call telephone = new Call();
		System.out.println("Please provide the following details to use telephone services.\n");
		initialize_userData();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\nSelect any service of your choice\n");
			System.out.println("1. Dail\t" + "2. Call" +  "\n3. Create Contact\t" + "4. Show Contacts" + "\n5. Search Contact\t" + "6. Delete Contact" + "\n7 : Call History\t"  +  "8. Exit");
			String opt = sc.next();
			switch(opt) {
			case "1":	telephone.dial();
						break;
			case "2":	System.out.println("Enter Contact Name : ");
						telephone.connectCall(sc.next());
						break;
			case "3":	System.out.println("Enter Contact Name: ");
						String name = sc.next();
						System.out.println("Enter Email ID: ");
						String email = null;
						do{
							email = new String(sc.nextLine());
						}
						while(!(validateEmail(email)));
						System.out.println("Enter Phone Number: ");
						String phn = sc.next();
						if(contact.addContact(name,email,phn)) {
							System.out.println("Added contact "+ name);
						}
						else {
							System.out.println("Failed to add contact " + name);
						}
						break;
			case "4":	contact.showContacts();
						break;
			case "5":	sc = new Scanner(System.in);
						System.out.println("Enter Contact Name : ");
						name = sc.nextLine();
						Contact temporary = contact.searchContact(name);
						if(temporary == null)
							System.out.println("Contact doesn't exist\n");
						break;
			case "6":	contact.deleteContact();
						break;
			case "7":	telephone.callHistory();
						break;
			case "8":	System.out.println("Thankyou for using our services\n");
						sc.close();
						System.exit(1);
			default : 	System.out.println("Choose a valid Option");
						break;
			}
		}
	}
}