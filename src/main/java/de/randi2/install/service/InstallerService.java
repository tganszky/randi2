package de.randi2.install.service;

import java.io.File;

import de.randi2.install.domain.Configuration;


/**
 * All installation-relevant services.
 * 
 * @author Thomas Ganszky
 */
interface InstallerService {

	/**
	 * 
	 * Apply created Configuration to this installation
	 * 
	 */
	public void applyConfiguration(Configuration c);

	/**
	 * 
	 * Apply created Configuration to this installation
	 * 
	 */
	public void applyConfiguration(File f);
	
	/**
	 * Returns current Configuration of this randi2 installation
	 * 
	 * @return configuration of this randi2 installation
	 */
	public Configuration getInstallationConfig();

	/**
	 * Returns current Configuration of this randi2 installation as a .conf file
	 * 
	 * @return file with all configuration parameters
	 */

	public File getCurrentConfiguration();

	
	/**
	 * Checks if randi2 has already been configured for usage.
	 * 
	 * @return true, if already configured; false, if not condfigured; exception, if check wasnt possible
	 */
	public boolean isConfigured() throws Exception;

}
