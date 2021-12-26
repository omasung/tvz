package com.tvz.demo.utility.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.tvz.demo.model.Users;
import com.tvz.demo.service.UsersService;
import com.tvz.demo.utility.service.VerificationEmailService;

@Transactional
@Service
public class VerificationEmailServiceImpl implements VerificationEmailService {

	@Autowired private UsersService usersService;	
	@Autowired private JavaMailSender emailSender;
	@Autowired private Configuration freemarkerConfig;

	@Override
	@Async("asyncExecutor")
	public Future<String> verificationInformation (Long usersId) throws MessagingException {
		
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		
		try {
			
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());				 
	        
		    /* Creating a data-model */
	        Map<String, Object> model = new HashMap<String, Object>();
	        
	        Users users = null;
	        users = usersService.getUsersByPk(usersId);
			
			model.put("fullName", users.getName());
			model.put("vfLink", "http://localhost/registration/verification/" + users.getVfCode());
		    
		    //Template path
	        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates/");
			
	        //Template
	        Template temp = freemarkerConfig.getTemplate("verify_account.ftlh");
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(temp, model);
	        
	        helper.setTo(users.getEmail());
	        helper.setText(html, true);
	        helper.setSubject("Verify Your Account");
	        
	        helper.setFrom(new InternetAddress("omasung4gud@gmail.com", "oma sung"));	
	        
	        emailSender.send(mimeMessage);
	        
	        completableFuture.complete("verification email sent successful");
	        System.out.println(completableFuture);
				
			} catch (TemplateException e) {

				e.printStackTrace();
				
			} catch (IOException e) {

				e.printStackTrace();
				
			}
		
		return completableFuture;
	}
	
}
