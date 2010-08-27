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

	@NotEmpty
	private String key;
	@NotEmpty
	private String value;

	/** The Login of the first user. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
	private Login login;

	private String mail_host;
	private String mail_username;
	private String mail_password;
	private String mail_from;
	private String info_server;
	private String info_hoster;

	// randi2.properties
	// logoPath=/hostingInstLogo.png
	private String sysopMail;
	private String randi2_version;
	private String website1;
	private String website2;
	// year=2010
	// selfRegistration=true
	private String abouttext;
	private String tst;
}
