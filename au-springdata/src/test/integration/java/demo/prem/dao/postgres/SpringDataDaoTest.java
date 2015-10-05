package demo.prem.dao.postgres;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import demo.prem.dao.ContactDao;
import demo.prem.dao.repo.ContactRepository;
import demo.prem.model.Contact;

@ContextConfiguration("classpath:/demo/prem/cfg/db-config-postgres_spring-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(false)
public class SpringDataDaoTest extends demo.prem.dao.hsql.SpringDataDaoTest{

}
