package com.accolite.au;

public interface Contact_Interface {
	public boolean addContact(String name,String email,String phoneno);
	boolean deleteContact();
	Contact searchContact(String name);
}

