package de.randi2.install.dao;

import de.randi2.dao.AbstractDaoHibernate;
import de.randi2.install.domain.Configuration;

import org.springframework.stereotype.Service;

/**
 * The Class PersonDaoHibernate.
 */
@Service("configurationDao")
public class ConfigurationDAOHibernate extends
		AbstractDaoHibernate<Configuration> implements ConfigurationDao {

	@Override
	public Class<Configuration> getModelClass() {
		return Configuration.class;
	}

}
