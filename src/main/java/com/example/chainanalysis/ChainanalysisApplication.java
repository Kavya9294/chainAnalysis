package com.example.chainanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@ComponentScan
@ComponentScan
@EnableAutoConfiguration
public class ChainanalysisApplication {
	private static final Logger log = LoggerFactory.getLogger(ChainanalysisApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ChainanalysisApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Coinbase cb=restTemplate.getForObject("https://api.coinbase.com/v2/prices/spot?currency=USD", Coinbase.class);
			log.info(cb.toString());

		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getCurrency").allowedOrigins("http://localhost:3001");

			}
		};
	}
}
