package de.randi2.install.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import de.randi2.install.dao.ConfigurationDAO;
import de.randi2.install.domain.Configuration;

@Service("InstallerService")
public class InstallerServiceImpl   implements  InstallerService{

	private Logger logger = Logger.getLogger(InstallerServiceImpl.class);
	@Autowired private ConfigurationDAO configurationDAO;
	
	//TODO nötig?
	//@Autowired private SessionFactory sessionFactory;
	
	@Override
	public void create(Configuration newConfig) {
		logger.info("create config");
		configurationDAO.create(newConfig);
		//sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public Configuration update(Configuration config) {
		
		//TODO prüfung einbauen, ob user berechtigt admin ist
		
			logger.info("user: " + SecurityContextHolder.getContext().getAuthentication().getName() + " updated configuration)");
			return configurationDAO.update(config);
		
	}

	

	@Override
	public void installRandi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkDBConn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkIfFirstInstallation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Configuration getInstallationConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	



}

