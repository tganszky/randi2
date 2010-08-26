/**
 * validation
 * 
 * @author Thomas Ganszky
 * @Version 0.0.1 initial
 */
package de.randi2.utility.validations;

import org.hibernate.validator.Validator;

public class InstallationValidator implements Validator<Installation> {

	@Override
	public void initialize(Installation arg0) {
	}

	@Override
	public boolean isValid(Object versionnumber) {
		String number = (String) versionnumber;
		if (number == null || number.trim().equals("")) {
			return false;
		}
		// TODO mehr validierungen, andere klassen? check ob alle installationsdaten korrekt sind?
		return true;
	}
}
