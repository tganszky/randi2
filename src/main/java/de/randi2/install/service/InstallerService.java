package de.randi2.install.service;

import de.randi2.install.domain.Configuration;
import de.randi2.model.Trial;
import de.randi2.services.AbstractService;


/**
 * All installation-relevant services.
 * 
 * @author Thomas Ganszky 
 */
interface InstallerService {

	/**
	 * 
	 * Check if RANDI2 has already been installed
	 * @return true if RANDI2 is not already installed, otherwise return false
	 */
	public boolean checkIfFirstInstallation();
	
	/**
	 * required actions?
	 */
	public void installRandi();
	
	/**
	 * 
	 * Check if DB Connection is available
	 * 
	 * @return true if DB conn available
	 */
	public boolean checkDBConn();
	
	/**
	 * Returns current Configuration of this randi2 installation
	 * @return configuration of this randi2 installation
	 */
	public Configuration getInstallationConfig();
	
	/**
	 * Stores a new config object in the system.
	 * 
	 * @param newConfig
	 */
	public void create(Configuration newConfig);

	/**
	 * Updates the configuration object and returns the its newest version.
	 * 
	 * @param config changed Configuration
	 * @return
	 */
	public Configuration update(Configuration config);

}
