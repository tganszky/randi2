package de.randi2.install.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import de.randi2.install.dao.ConfigurationDAO;
import de.randi2.install.domain.Configuration;

@Service("InstallerService")
public class InstallerServiceImpl   implements  InstallerService{

	@Override
	public void applyConfiguration(Configuration c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getCurrentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration getInstallationConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConfigured() throws Exception {
		// todo check
		return false;
	}



	



}

