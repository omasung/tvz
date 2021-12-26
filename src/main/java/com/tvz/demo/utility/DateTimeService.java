package com.tvz.demo.utility;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;

@Service
public class DateTimeService {
		
	public LocalDateTime PresentDateTime() {
		
		LocalDateTime now = LocalDateTime.now(ZoneOffset.of("+1"));
		
		return now;
	}
	
}
