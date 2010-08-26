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
@EqualsAndHashCode(callSuper=true)
public class Configuration extends AbstractDomainObject{
	
	private static final long serialVersionUID = 1185826192804499840L;

	@NotEmpty
	private String key;
	@NotEmpty
	private String value;
	
	/** The Constant MAX_NAME_LENGTH. */
	public final static int MAX_NAME_LENGTH = 50;
	
	/** The Constant MAX_TITLE_LENGTH. */
	public final static int MAX_TITLE_LENGTH = 20;
	
	// Persons Data
	/** The surname. */
	@NotEmpty
	@Length(max=MAX_NAME_LENGTH)
	private String surname = "";
	
	/** The firstname. */
	@NotEmpty
	@Length(max=MAX_NAME_LENGTH)
	private String firstname = "";
	
	/** The title. */
	@Length(max=MAX_TITLE_LENGTH)
	private String title = "";

	// Contact Data
	/** The email. */
	@EMailRANDI2
	@NotEmpty
	private String email = "";

	/** The phone. */
	@TelephonNumber
	@NotEmpty
	private String phone = "";
	
	/** The mobile. */
	@TelephonNumber
	private String mobile = "";

	/** The fax. */
	@TelephonNumber
	private String fax = "";
	
	// Institutional Data
	/** The assistant. */
	@ManyToOne(cascade=CascadeType.ALL)
	@ContactPerson
	private Person assistant;
	
	/** The trial site. */
	@ManyToOne
	private TrialSite trialSite;

	// Login data
	/** The login. */
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="person")
	private Login login;

	
	//Installation Data
	@versionnumber
	private String versionnumber
	
	//mail.host=localhost
	//mail.username=randi2
	//mail.password=randi2
	//mail.from=randi2@randi2.de
	//info.server=http://randi2.org
	//info.hoster=RANDI2 Team
	//
	//
	//
	//randi2.properties
	//logoPath=/hostingInstLogo.png
	//sysopMail=ds@randi2.de
	//version=
	//website1=http\://www.randi2.de
	//website2=http\://www.dkfz.de
	//year=2010
	//selfRegistration=true
	
	
	/* (non-Javadoc)
	 * @see de.randi2.model.AbstractDomainObject#getUIName()
	 */
	@Override
	public String getUIName() {
		return this.getSurname()+", "+this.getFirstname();
	}
}
