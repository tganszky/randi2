package de.randi2.install.domain;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import de.randi2.model.AbstractDomainObject;
import de.randi2.model.Login;
import de.randi2.model.Person;
import de.randi2.model.TrialSite;
import de.randi2.model.enumerations.Gender;
import de.randi2.utility.validations.ContactPerson;
import de.randi2.utility.validations.EMailRANDI2;
import de.randi2.utility.validations.TelephonNumber;

@Data
@EqualsAndHashCode(callSuper = true)
public class Configuration extends AbstractDomainObject {

	private static final long serialVersionUID = 1185826192804499840L;

	// @NotEmpty
	// private String key;
	// @NotEmpty
	// private String value;

	/** The Login of the first user. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
	private Login login;

	/**
	 * Mail hosting address
	 */
	private String mail_host;
	/**
	 * Username for mailserver login
	 */
	private String mail_username;
	/**
	 * Password for mailserver login
	 */
	private String mail_password;
	/**
	 * reply to - address of mailserver
	 */
	private String mail_from;

	/**
	 * Info Server
	 */
	private String info_server;
	/**
	 * Information about hoster 
	 */
	private String info_hoster;

	
	/**
	 * Email address of this installations Sysop
	 */
	private String sysopMail;
	/**
	 * Randi2 Version
	 */
	private String randi2_version;
	/**
	 * Institutions website 1
	 */
	private String website1;
	/**
	 * Institutions website 2
	 */
	private String website2;
	/**
	 * About this installation
	 */
	private String abouttext;

	

}
