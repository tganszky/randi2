package de.randi2.install.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import de.randi2.model.AbstractDomainObject;
import de.randi2.model.Login;
import de.randi2.utility.validations.EMailRANDI2;
/**
 * Configuration
 * @author tg
 *
 */
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
	private Login login;

	
	/**
	 * sender-address of mailserver eg."randi2@example.net"
	 */
	@EMailRANDI2
	@NotEmpty
	private String mailFrom;

	/**
	 *  Server Address, eg."http://randi2.org"
	 */
	@NotNull
	private String hostingServerAddress;

	// ****************
	// Information Part
	// ****************

	
	/**
	 * Address of institution website
	 */
	@NotNull
	private String website1;

	/**
	 * Address of additional website (eg. trial site)
	 */
	@NotNull
	private String website2;

	// pages.aboutPopup.header
	/**
	 * About this installation-header
	 */
	@NotNull
	private String headerInstallationInformationText;

	// pages.aboutPopup.content
	/**
	 * About this installation
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
	 * short Information about hoster, eg. "Randi2 Team"
	 * 
	 */
	@NotNull
	private String infoAboutHoster;

	

	
	
}
