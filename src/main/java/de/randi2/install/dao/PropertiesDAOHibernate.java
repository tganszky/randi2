package de.randi2.install.dao;

import de.randi2.dao.AbstractDaoHibernate;
import de.randi2.install.domain.Property;


public class PropertiesDAOHibernate extends AbstractDaoHibernate<Property> implements
PropertiesDAO {

	@Override
	public Class<Property> getModelClass() {
		// TODO Auto-generated method stub
		return Property.class;
	}

}
