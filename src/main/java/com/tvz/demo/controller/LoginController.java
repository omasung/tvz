package com.tvz.demo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public ModelAndView signupForm(ModelAndView model) throws IOException {			
			
			model.setViewName("login");				
								
			return model;
	}
	
}
