package com.smd.umake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(title="API - UMake", version="1", description="API Desenvolvida para o trabalho de Banco de Dados I"))
public class UmakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmakeApplication.class, args);
	}

  @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
				registry.addMapping("/api/v1/").allowedOrigins("http://localhost:46843");
				registry.addMapping("/api/v1/").allowedOrigins("http://app:46843");
				registry.addMapping("/api/v1/").allowedOrigins("http://flutter_app:46843");
			}
		};
	}

}
