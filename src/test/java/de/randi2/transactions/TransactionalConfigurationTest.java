package de.randi2.transactions;

import de.randi2.install.dao.ConfigurationDao;
import de.randi2.install.domain.Configuration;




public class TransactionalConfigurationTest extends AbstractTransactionalTest<ConfigurationDao,Configuration> {

	@Override
	protected void init() {
		dao = (ConfigurationDao) applicationContext.getBean("configurationDao");
		object = factory.getConfiguration();
	}

}
