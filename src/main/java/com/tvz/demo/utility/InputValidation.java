package com.tvz.demo.utility;

import org.springframework.stereotype.Service;

@Service
public class InputValidation {

	public Boolean validateNumeric(String input) {

		Boolean bool = false;

		if (input != null && input.matches("[0-9]+") == true) {

			bool = true;

		}

		return bool;
	}
	
	public Boolean validateAlphanumeric(String input) {

		Boolean bool = true;

		if (input == null || input.isEmpty()) {

			bool = false;

		}

		return bool;
	}
	
}
