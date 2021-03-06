package demo.prem.dao.hsql;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import demo.prem.dao.repo.AccountRepository;
import demo.prem.dao.repo.ContactRepository;
import demo.prem.dao.repo.PatientRepository;
import demo.prem.model.Account;
import demo.prem.model.AccountType;
import demo.prem.model.Contact;
import demo.prem.model.GenderType;
import demo.prem.model.Patient;

@ContextConfiguration("classpath:/demo/prem/cfg/db-config-hsql_spring-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext
public class SpringDataDaoTest {

	@Autowired
	AccountRepository acctRepo;

	@Autowired
	PatientRepository patRepo;
	@Autowired
	ContactRepository contactRepo;

	@Test
	public void testAccount() {
		Account acct = new Account();
		acct.setAccountType(AccountType.Hospital);
		acct.setDescription("Whatever1");
		acct.setName("Seattle Childrens hospital");
		Account savedAcct  = acctRepo.save(acct);
		System.out.println("Saved Acct = " + savedAcct);
		Iterable<Account> acctList = acctRepo.findAll();
		System.out.println("Act = " + acctList);
	}
	

	@Test
	public void testPatientDao() {
		Patient pat = new Patient();
		pat.setDateOfBirth(new Date());
		pat.setFirstName("Jane");
		pat.setLastName("Doe");
		pat.setGender(GenderType.Female);
		pat.setMrn("112321abcd123");
		Patient savedPat  = patRepo.save(pat);
		System.out.println("Saved Pat = " + savedPat);
		Iterable<Patient> patList = patRepo.findAll();
		System.out.println("Pat = " + patList);
	}
	
	@Test
	public void testContactDao() {
		Contact contact = new Contact();
		contact.setEmail("bla@gmail");
		contact.setName("Jane Doe");
		contact.setPhone("111 1111");
		Contact savedContact  = contactRepo.save(contact);
		System.out.println("Saved Contact = " + savedContact);
		Iterable<Contact> contactList = contactRepo.findAll();
		System.out.println("Contact = " + contactList);
	}


}
