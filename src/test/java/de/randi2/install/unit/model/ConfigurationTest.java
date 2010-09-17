package de.randi2.install.unit.model;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.randi2.install.domain.Configuration;
import de.randi2.model.Login;
import de.randi2.testUtility.utility.AbstractDomainTest;

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

	@Ignore
	public void testGetRequiredFields() {
		Map<String, Boolean> map = validConfig.getRequiredFields();
		for (String key : map.keySet()) {
			System.out.println(key);
		}
	}



	@Test
	public void testLoginAvailable() {
		validConfig.setLogin(new Login());
		assertNotNull(validConfig.getLogin());
		assertValid(validConfig);
	}

	@Test
	public void testLoginNotAvailable() {
		validConfig.setLogin(null);
		assertNull(validConfig.getLogin());
		assertInvalid(validConfig);
	}

	@Test
	public void testMailFromNotNull() {
		validConfig.setMailFrom(null);
		assertInvalid(validConfig);
	}

	@Test
	public void testMailFromNotEmpty() {
		validConfig.setMailFrom("");
		assertInvalid(validConfig);
	}

	@Test
	public void testMailFromCorrectValues() {
		String[] validEMails = { "abc@def.de", "h@alo.com",
				"info@2wikipedia.org", "mue5ller@gmx.net", "max-muster@raf.uk",
				"xyz@test.info" };
		for (String s : validEMails) {
			validConfig.setMailFrom(s);
			assertValid(validConfig);
		}
	}

	@Test
	public void testEMailIncorrectValues() {
		String[] invalidEmails = new String[] { "without at", "toomuch@@",
				"@test.org", "ab..c@de-dg.com", "without@domain",
				"abc@def.abcde" };
		for (String s : invalidEmails) {
			validConfig.setMailFrom(s);
			assertInvalid(validConfig);
		}
	}

	@Test
	public void testInstallationInformationTextValid() {
		String[] validText = { stringUtil.getWithLength(4000),
				stringUtil.getWithLength(0), "", stringUtil.getWithLength(400) };
		for (String s : validText) {
			validConfig.setInstallationInformationText(s);
			assertValid(validConfig);
		}
		assertValid(validConfig);
	}

	@Test
	public void testInstallationInformationTextInvalid() {
		validConfig.setInstallationInformationText(null);
		assertInvalid(validConfig);
	}

	@Test
	public void testHostingServerAddressInvalid() {

		String[] invalidUrls = new String[] { "einwort", "just text",
				"email@isnotallow.edu", "test.", ".ab.com",
				"mailnotto:domain@dudeldidu.com", "htp://def.abc-de" };
		for (String s : invalidUrls) {
			validConfig.setHostingServerAddress(s);
			assertInvalid(validConfig, s);
		}
	}

	@Test
	public void testHostingServerAddressNull() {
		validConfig.setHostingServerAddress(null);
		assertInvalid(validConfig);
	}

	@Test
	public void testHostingServerAddressValid() throws MalformedURLException {
		String[] validUrls = new String[] { "http://localhost:8080", "www.exampleee.net/",
				"http://secret-stuff.com", "ftp://ftp.com",
				"http://www.randi2.org", "randi2.org",  "marek.mintal.com"};
		for (String s : validUrls) {
			validConfig.setHostingServerAddress(s);
			assertValid(validConfig);
		}
	}

}
