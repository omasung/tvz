package com.tvz.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tvz.demo.model.Users;
import com.tvz.demo.service.UsersService;
import com.tvz.demo.utility.DateTimeService;
import com.tvz.demo.utility.GenerationService;
import com.tvz.demo.utility.InputValidation;
import com.tvz.demo.utility.service.VerificationEmailService;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired private UsersService usersService;
	@Autowired private DateTimeService dateTimeService;
	@Autowired private InputValidation inputValidation;
	@Autowired private GenerationService generationService;
	@Autowired private VerificationEmailService verificationEmailService;

	@RequestMapping(value = "/form", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView registrationForm(ModelAndView model, @ModelAttribute("users") Users users) throws IOException, MessagingException {	
		
			if (users.getUsername() != null) {
				
				String message = "";
				
				if (usersService.getUsersByUsername(users.getUsername()) == null
						&& usersService.getUsersByEmail(users.getEmail()) == null) {//Email and user name does not exist
				
					try {
						
						LocalDateTime dateTime = dateTimeService.PresentDateTime();
						
						users.setPvt(false);
						users.setVerified(false);
						users.setVfCode(generationService.verificationCode());
						users.setSignupDate(dateTime);
						usersService.addUsers(users);
						
						verificationEmailService.verificationInformation(users.getId());
						
				        return new ModelAndView("redirect:/registration/message/"+users.getId());
			        
					} catch (MessagingException e) {
						
						e.printStackTrace();
						
					}
		        
				} else if (usersService.getUsersByUsername(users.getUsername()) != null) {//User name already exist
					
					message = "A user with the username " + users.getUsername() + " already exist";
		        	model.addObject("message", message);
		        	
				} else if (usersService.getUsersByEmail(users.getEmail()) != null) {//Email already exist
					
					message = "A user with the email " + users.getEmail() + " already exist";
		        	model.addObject("message", message);
					
				}
		        	
			}
		
			model.setViewName("registration");				
								
			return model;
	}

	@RequestMapping(value = "/message/{Id}", method = {RequestMethod.GET})
	public ModelAndView registrationMessage(ModelAndView model, @PathVariable String Id) throws IOException {			
			
				String pageTitle = "";
				String message = "";
	
				pageTitle = "Reg Message";
				
				model.addObject("pageTitle", pageTitle);
				model.addObject("message", message);
			
			if (inputValidation.validateNumeric(Id).equals(false)) {//Validate Id
				
				model.addObject("pageTitle", pageTitle);
				model.addObject("message", "Sorry, something went wrong, please try again later !");
				
			} else if (usersService.getUsersByPk(Long.parseLong(Id)).getVerified() == false) {//Fetch that user that just registered
				
				Users users = usersService.getUsersByPk(Long.parseLong(Id));
				
				message = "Your registration was successful. we just sent a verification link to your registered "
						  + "email address " + users.getEmail() + " kindly click on the link to verify your account. Thank you";
				
				model.addObject("pageTitle", pageTitle);
				model.addObject("message", message);
				
			} else {//
				
				model.addObject("pageTitle", pageTitle);
				model.addObject("message", "Sorry, you should not be accessing this url at the moment !");				
				
			}			
			
			model.setViewName("message");				
								
			return model;
	}		
	
	@RequestMapping(value = "/verification/{vfCode}", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView registrationVerification(ModelAndView model, @PathVariable String vfCode) throws IOException {
		
			if (inputValidation.validateAlphanumeric(vfCode).equals(false)) {//Validate vfCode
				
				model.addObject("pageTitle", "Verificaion Message");
				model.addObject("message", "Sorry, we are having trouble verifying your email");
				
			} else if (usersService.getUsersByVerificationCode(vfCode) != null
							&& usersService.getUsersByVerificationCode(vfCode).getVerified() == false) {//Account yet to be verified
				
				Users users = usersService.getUsersByVerificationCode(vfCode);				
				users.setVerified(true);
				usersService.updateUsers(users);
				
				model.addObject("pageTitle", "Verificaion Message");
				model.addObject("message", "We have successfully verified your account, thank you !");
				
			} else if (usersService.getUsersByVerificationCode(vfCode) != null
							&& usersService.getUsersByVerificationCode(vfCode).getVerified() == true) {//Account already verified
				
				model.addObject("pageTitle", "Verificaion Message");
				model.addObject("message", "The email associated with this account has already been verified !");
				
			} else {//
				
				model.addObject("pageTitle", "Verificaion Message");
				model.addObject("message", "Sorry, we could not verify your account at the moment !");				
				
			}
		
			model.setViewName("message");				
								
			return model;
	}	
	
}
