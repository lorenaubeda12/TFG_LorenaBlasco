package com.example.BrainHelp_TFG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BrainHelpTfgApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BrainHelpTfgApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BrainHelpTfgApplication.class);
	}
}
