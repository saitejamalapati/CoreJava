package com.accolite.au;

import java.math.BigInteger;
import java.util.Scanner;

public class Contact implements Contact_Interface{
	protected String contact_name = "";
	protected String email = "";
	protected BigInteger phone = null;
	
	Contact(){}

	Contact(String name,String email,BigInteger phoneno){
		this.contact_name = name;
		this.email = email;
		this.phone = phoneno;
	}

	@Override
	public boolean addContact(String name,String email,String phoneno){		
		BigInteger phn_no = null;
		Contact obj = null;
		if(!(searchContact(name) == null)) {
			System.out.println("Contact Already Exists\n");
			return false;
		}
		try {
			if(phoneno.length() != 10) {
				System.out.println("Enter Correct Phone Number\n");
			}
			phn_no = new BigInteger(phoneno);
			obj = new Contact(name,email,phn_no);
		}
		catch(Exception e) {
			System.out.println("Enter a Valid Phone Number\n");
			e.printStackTrace();
			return false;
		}
		if(obj!= null && Mobile.contact_arr.add(obj))
			return true;
		return false;
	}
	
	@Override
	public Contact searchContact(String name) {
		for(Contact obj : Mobile.contact_arr) {
			if(obj.contact_name.equals(name)) {
				System.out.println("Name : " + obj.contact_name);
				System.out.println("Phone Number : " + obj.phone);
				System.out.println("Email id : " + obj.email);
				return obj;
			}
		}
		return null;
	}

	@Override
	public boolean deleteContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Contact name : ");
		String name = sc.nextLine();
		for(Contact obj : Mobile.contact_arr) {
			if(obj.contact_name.equals(name)) {
				Mobile.contact_arr.remove(obj);
				System.out.println("Deleted Contact " + obj.contact_name + "\n");
				return true;
			}
		}
		System.out.println("Contact doesn't exist\n");
		sc.close();
		return false;
	}

	void showContacts() {
		for(Contact obj : Mobile.contact_arr) {
			System.out.println("Name : " + obj.contact_name);
			System.out.println("Phone Number : " + obj.phone);
			System.out.println("Email id : " + obj.email);
			System.out.println("\n");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact_name == null) ? 0 : contact_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contact_name == null) {
			if (other.contact_name != null)
				return false;
		} else if (!contact_name.equals(other.contact_name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
}

