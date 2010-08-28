package de.randi2.install;

import static org.junit.Assert.*;

import java.util.Map;

import org.hibernate.validator.InvalidStateException;
import org.hibernate.validator.InvalidValue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.randi2.install.domain.Configuration;
import de.randi2.model.Person;
import de.randi2.model.exceptions.ValidationException;
import de.randi2.test.utility.AbstractDomainTest;

/**
 * Validation and Tests for Configuration Objects
 * 
 * @author Thomas Ganszky
 * 
 */
public class ConfigurationTest extends AbstractDomainTest<Configuration> {

	private Configuration validConfig;
	
	public ConfigurationTest() {
		super(Configuration.class);
	}

	@Before
	public void setUp() {
		validConfig = super.factory.getConfiguration();
	}

	@Test(expected = ValidationException.class)
	public void testValidation() {
		validConfig.checkValue("sysopMail", stringUtil.getWithLength(4));
		validConfig.checkValue("mail_from", stringUtil.getWithLength(100));
		
	}

	@Test
	public void testConstructor() {
		Configuration c = new Configuration();
		Person p = new Person();
	
		assertEquals("", p.getFirstname());
		assertEquals("", c.getMail_host());
		assertEquals("", c.getMail_username());
		assertEquals("", c.getMail_password());
		assertEquals("", c.getMail_from());
		assertEquals("", c.getInfo_server());
		assertEquals("", c.getSysopMail());
		assertEquals("", c.getRandi2_version());
		assertEquals("", c.getWebsite1());
		assertEquals("", c.getWebsite2());
		assertEquals("", c.getPop_header_abouttext1());
		assertEquals("", c.getPop_abouttext1());
		assertEquals("", c.getPop_header());
		assertEquals("", c.getPop_header_info_hoster());
		assertEquals("", c.getPop_info_hoster());
		assertEquals("", c.getInfo_hoster());
	}

	

	

	@Test
	public void testGetRequiredFields() {
		Map<String, Boolean> map = validConfig.getRequiredFields();
		for (String key : map.keySet()) {
			System.out.println(key);
		}
	}

	@Test
	public void testToString() {
		assertNotNull(validConfig.toString());
	}
	
	

	
}
