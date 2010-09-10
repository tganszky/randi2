package de.randi2.install.integration.dao;

import static de.randi2.testUtility.utility.RANDI2Assert.assertNotSaved;
import static de.randi2.testUtility.utility.RANDI2Assert.assertSaved;
import static junit.framework.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.util.AssertException;

import de.randi2.install.dao.ConfigurationDao;
import de.randi2.install.domain.Configuration;
import de.randi2.testUtility.utility.DomainObjectFactory;
import de.randi2.testUtility.utility.TestStringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring-test.xml" })
@Transactional
public class ConfigurationDaoTest {

	@Autowired
	private ConfigurationDao configDao;
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

		assertNotSaved(c);
		configDao.create(c);
		assertSaved(c);

		assertNotNull(configDao.get(c.getId()));

	}

	@Test
	public void testGetConfig() {
		Configuration c = factory.getConfiguration();
		String s = "creation@exmple.net";
		c.setMailFrom(s);
		configDao.create(c);

		List<Configuration> l = configDao.getAll();

		assertNotNull(l);
		assertTrue(l.size() == 1);
		assertNotNull("This assertion failed", l.get(0));
		Configuration d = l.get(0);
		assertEquals(s, d.getMailFrom());

	}

}
