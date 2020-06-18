package com.accolite.opportunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpportunityMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpportunityMgmtApplication.class, args);
	}

//	@Value("app.allowed-origins")
//	private String[] allowedOrigins;
//
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins(allowedOrigins);
//			}
//		};
//	}

}
