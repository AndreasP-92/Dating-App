package com.example.datingAppDataConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class DatingAppDataConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatingAppDataConnectApplication.class, args);
	}

}
