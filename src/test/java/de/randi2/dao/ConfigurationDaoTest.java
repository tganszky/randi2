package de.randi2.dao;

import static de.randi2.test.utility.RANDI2Assert.assertNotSaved;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

import org.hibernate.validator.InvalidStateException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.randi2.model.Configuration;


import de.randi2.test.utility.DomainObjectFactory;
import de.randi2.test.utility.TestStringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring-test.xml" })
public class ConfigurationDaoTest {

	@Autowired
	private ConfigurationDao dao;
	@Autowired
	private DomainObjectFactory factory;
	@Autowired
	protected TestStringUtil stringUtil;

	private Configuration validConfig;

	@Before
	public void setUp() {
		validConfig = factory.getConfiguration();
	
	}

	@Test
	public void createAndSaveTest() {

		Configuration c = factory.getConfiguration();
		
		c.setMail_username("test");
		
		dao.create(c);
	
		assertNotNull(dao);
		assertNotNull(dao.get(c.getId()));

	}

	@Test
	public void testSaveWithLogin() {
		validConfig.setPop_abouttext1("abouttext");
		validConfig.setInfo_hoster("info hoster");
		validConfig.setInfo_server("info server");

		validConfig.setMail_from("mail from");
		validConfig.setMail_host("mail host");
		validConfig.setMail_password("mail pwd");
		validConfig.setMail_username("mail username");
		validConfig.setRandi2_version("versionsnummer");
		validConfig.setSysopMail("just another email");

		try {
			dao.update(validConfig);

		} catch (InvalidStateException e) {
		}
	}

	@Ignore
	public void testGetAll() {
		for (int i = 0; i < 100; i++) {
			dao.create(factory.getConfiguration());
		}
		assertTrue("getAll failed", dao.getAll().size() > 100);
	}
}
