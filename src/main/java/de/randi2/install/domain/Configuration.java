package de.randi2.install.domain;

import java.net.URL;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import de.randi2.model.AbstractDomainObject;
import de.randi2.model.Login;
import de.randi2.utility.validations.EMailRANDI2;
import de.randi2.utility.validations.UrlRANDI2;

/**
 * Configuration
 * 
 * @author Thomas Ganszky
 * 
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "login" })
@ToString(exclude = { "login" })
public class Configuration extends AbstractDomainObject {

	private static final long serialVersionUID = 1185826192804499840L;

	public Configuration() {

	}

	// ****************
	// Technical Part
	// ****************

	/** The Login of the very first user. */
	@NotNull
	private Login login;

	/**
	 * sender-address of mailserver eg."randi2@example.net"
	 */
	@EMailRANDI2
	@NotEmpty
	private String mailFrom;

	/**
	 * Server Address, eg."http://randi2.org"
	 */
	@UrlRANDI2
	@NotNull
	private String hostingServerAddress;

	// ****************
	// Information Part
	// ****************

	/**
	 * Address of institution website
	 */
	@UrlRANDI2
	@NotNull
	private String website1;

	/**
	 * Address of additional website (eg. trial site)
	 */
	@UrlRANDI2
	private String website2;

	/**
	 * Hosting institution may enter some information text to describe this
	 * installation, e.g. about usage of this installation,
	 */
	@NotNull
	private String installationInformationText;

	// pages.aboutPopup.hostingInst
	/**
	 * About this installation
	 */
	@NotNull
	private String infoAboutInstallation;

	/**
	 * short Information about host or hosting company, e.g. "Randi2 Team"
	 * 
	 */
	@NotNull
	private String infoAboutHost;

}
