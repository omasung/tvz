package com.tvz.demo.utility;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class GenerationService {

	public String verificationCode () {
		
		String token = "";		
		Random random = new Random((new Date()).getTime());
		int lenght = 25;

		char[] values = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			             'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
			             'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3',
			             '4', '5', '6', '7', '8', '9'};

		for (int i = 0; i < lenght; i++) {
			int idx = random.nextInt(values.length);
			token += values[idx];
		}

		System.out.println("The generated verification code " + token);
		
		return token;
	}
	
}