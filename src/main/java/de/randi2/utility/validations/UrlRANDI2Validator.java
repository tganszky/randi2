package de.randi2.utility.validations;

import java.net.MalformedURLException;
import java.net.URL;

import org.hibernate.validator.Validator;

/**
 * Check for URL conformity
 * 
 * @author Thomas Ganszky
 * 
 */
public class UrlRANDI2Validator implements Validator<UrlRANDI2> {

	@Override
	public void initialize(UrlRANDI2 parameters) {
	}

	@Override
	public boolean isValid(Object value) {
		if (value == null)
			return false;
		else if (!(value instanceof String))
			return false;
		else {
			String url = (String) value;

			try {
				new URL(url);
			} catch (MalformedURLException e) {
				try {
					if (url.contains(".") && !url.contains(":")
							&& !url.contains("@") && !url.endsWith(".")
							&& !url.startsWith(".")) {
						new URL("http://" + url);
					} else {
						return false;
					}
				} catch (MalformedURLException e1) {
					return false;
				}

				return true;
			}
			return true;

		}
	}

}
