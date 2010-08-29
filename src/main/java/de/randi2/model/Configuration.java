package de.randi2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import de.randi2.utility.validations.EMailRANDI2;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "login"})
@ToString(exclude = { "login" })
public class Configuration extends AbstractDomainObject {

	private static final long serialVersionUID = 1185826192804499840L;

	public Configuration() {

	}

	// ****************
	// Technical Part
	// ****************

	// TODO not sure about the required items for mail configuration

	/** The Login of the first user. */
	@NotNull
	@NotEmpty
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
	private Login login;

	/**
	 * Mail hosting address
	 */
	@NotNull
	@NotEmpty
	private String mail_host = "";
	/**
	 * Username for mailserver login
	 */
	@NotNull
	private String mail_username = "";
	/**
	 * Password for mailserver login
	 */
	@NotNull
	private String mail_password = "";
	/**
	 * sender-address of mailserver eg."randi2@example.net"
	 */
	@EMailRANDI2
	@NotEmpty
	private String mail_from = "";

	/**
	 * Info Server, eg."http://randi2.org"
	 */
	@NotNull
	private String info_server = "";

	/**
	 * Email address of this installations Sysop
	 */
	@EMailRANDI2
	@NotEmpty
	private String sysopMail = "";

	// ****************
	// Information Part
	// ****************

	// TODO ist es sinnvoll, dass man selbst die versionsnummer angeben kann?
	/**
	 * Randi2 Version
	 */
	@NotNull
	private String randi2_version = "";

	/**
	 * Address of institution website
	 */
	@NotNull
	private String website1 = "";

	/**
	 * Address of additional website (eg. trial site)
	 */
	@NotNull
	private String website2 = "";

	// pages.aboutPopup.header
	/**
	 * About this installation-header
	 */
	@NotNull
	private String pop_header_abouttext1 = "";

	// pages.aboutPopup.content
	/**
	 * About this installation
	 */
	@NotNull
	private String pop_abouttext1 = "";

	// pages.aboutPopup.header
	/**
	 * About this installation-header
	 */
	@NotNull
	private String pop_header = "";

	// pages.aboutPopup.info2
	/**
	 * About this installation-header eg. "About this installation"
	 */
	@NotNull
	private String pop_header_info_hoster = "";

	// pages.aboutPopup.hostingInst
	/**
	 * About this installation
	 */
	@NotNull
	private String pop_info_hoster = "";

	/**
	 * short Information about hoster, eg. "Randi2 Team"
	 * 
	 */
	@NotNull
	private String info_hoster = "";

	

}
