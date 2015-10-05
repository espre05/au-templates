package demo.prem.dao;

import java.util.List;

import demo.prem.model.Contact;

public interface ContactDao {

	List<Contact> getContacts();
	
	void deleteContact(int id);
	
	Contact saveContact(Contact contact);
	
}
