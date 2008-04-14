package de.randi2.dao;

public interface AbstractDao<E extends Object> {

	public E get(Long id);
	
	public void save(E object);
	
}
