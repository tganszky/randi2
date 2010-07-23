package de.randi2.install.service;

import de.randi2.services.AbstractService;


/**
 * All installation-relevant services.
 * 
 * @author Thomas Ganszky 
 */
interface InstallerService {

	/**
	 * 
	 * Check db if this is the first run?
	 */
	public boolean checkInstallation();
	
	/**
	 * required actions?
	 */
	public void installRandi();

}
