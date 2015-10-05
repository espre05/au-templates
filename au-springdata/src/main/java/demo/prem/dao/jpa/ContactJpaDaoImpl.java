package demo.prem.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.prem.dao.ContactDao;
import demo.prem.model.Contact;

@Repository
public class ContactJpaDaoImpl extends AbstractJpaDAO< Contact> {
 
   public ContactJpaDaoImpl(){
      setClazz(Contact.class );
   }


}