package com.tvz.demo.utility.service;

import java.util.concurrent.Future;

import javax.mail.MessagingException;

public interface VerificationEmailService {

	Future<String> verificationInformation(Long usersId) throws MessagingException;

}
