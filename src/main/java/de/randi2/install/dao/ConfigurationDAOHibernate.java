package de.randi2.install.dao;

import de.randi2.dao.AbstractDaoHibernate;
import de.randi2.install.domain.Configuration;


public class ConfigurationDAOHibernate extends AbstractDaoHibernate<Configuration> implements
ConfigurationDAO {

	@Override
	public Class<Configuration> getModelClass() {
		// TODO Auto-generated method stub
		return Configuration.class;
	}

}
