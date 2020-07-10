package org.olm.core.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AnsibleAlmStubApplication extends SpringBootServletInitializer{

	private static Class<AnsibleAlmStubApplication> applicationClass = AnsibleAlmStubApplication.class;
	
	public static void main(String[] args) {
		SpringApplication.run(AnsibleAlmStubApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

}
