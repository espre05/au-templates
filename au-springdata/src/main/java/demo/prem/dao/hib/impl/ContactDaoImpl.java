package demo.prem.dao.hib.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import demo.prem.dao.ContactDao;
import demo.prem.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao{
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * Get List of contacts from database
	 * @return list of all contacts
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContacts() {
		List<Contact> contactList = (List<Contact>) hibernateTemplate.find("from Contact");
		return contactList;
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteContact(int id){
		Object record = hibernateTemplate.load(Contact.class, id);
		hibernateTemplate.delete(record);
	}
	
	/**
	 * Create a new Contact on the database or
	 * Update contact
	 * @param contact
	 * @return contact added or updated in DB
	 */
	@Override
	public Contact saveContact(Contact contact){
		hibernateTemplate.saveOrUpdate(contact);
		hibernateTemplate.flush();
		return contact;
	}

}
