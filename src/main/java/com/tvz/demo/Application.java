package com.tvz.demo;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@SpringBootApplication
public class Application extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {
		
		public static void main(String[] args) {

			 SpringApplication.run(Application.class, args);
			 
		}

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
					
			return builder.sources(Application.class);
			
		}
		
		@Bean
		@Autowired
	    public HibernateTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){		
		
	        return new HibernateTransactionManager(entityManagerFactory.unwrap(SessionFactory.class));
	        
	    }
		
	
}
