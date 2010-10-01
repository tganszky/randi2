package de.randi2.install.controllerBeans;

import lombok.Setter;
import de.randi2.install.service.*;

/**
 * <p>
 * This class cares about the process of a new RANDI2 installation, regarding
 * the interaction with the user via GUI
 * </p>
 * 
 * @author Thomas Ganszky
 */
public class InstallationHandler {

	@Setter
	private InstallerService instService;
	
	

}
