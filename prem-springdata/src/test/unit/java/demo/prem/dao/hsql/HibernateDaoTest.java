package demo.prem.dao.hsql;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import demo.prem.dao.ContactDao;
import demo.prem.model.Contact;

@ContextConfiguration("classpath:/demo/prem/cfg/db-config-hsql-hibernate.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext
public class HibernateDaoTest {

	@Autowired
	ContactDao contactDao;

	@Test
	@Rollback(true)
	public void test() {
		Contact contact = new Contact();
		contact.setEmail("bla@gmail");
		contact.setName("Jane Doe");
		contact.setPhone("111 1111");
		Contact savedContact  = contactDao.saveContact(contact);
		System.out.println("Saved Contact = " + savedContact);
		List<Contact> contactList = contactDao.getContacts();
		System.out.println("Contact = " + contactList);
	}

}
