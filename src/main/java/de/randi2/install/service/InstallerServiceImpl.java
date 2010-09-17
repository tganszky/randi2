package de.randi2.install.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.randi2.install.dao.ConfigurationDao;
import de.randi2.install.domain.Configuration;

@Service("InstallerService")
public class InstallerServiceImpl implements InstallerService {

	@Autowired
	private ConfigurationDao configDao;

	@Override
	public void applyConfiguration(Configuration c) {
		configDao.update(c);
	}

	@Override
	public File exportCurrentConfiguration() {

		configDao.getAll();
		// TODO generate file with contents of configuration
		return null;
	}

	@Override
	public Configuration getCurrentConfiguration() {
		// 
		return configDao.getAll().get(0);
	}

	@Override
	public boolean isConfigured() throws Exception {

		return null != configDao.getAll().get(0);F
	}

	@Override
	public void applyConfiguration(File f) {
		// TODO create configuration from file
	}

}
