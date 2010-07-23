package de.randi2.install.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.NotEmpty;

import de.randi2.model.AbstractDomainObject;

@Data
@EqualsAndHashCode(callSuper=true)
public class Configuration extends AbstractDomainObject{
	
	private static final long serialVersionUID = 1185826192804499840L;

	@NotEmpty
	private String key;
	@NotEmpty
	private String value;
}
