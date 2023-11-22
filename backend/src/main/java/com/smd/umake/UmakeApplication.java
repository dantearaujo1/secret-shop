package com.smd.umake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(title="API - UMake", version="1", description="API Desenvolvida para o trabalho de Banco de Dados I"))
public class UmakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmakeApplication.class, args);
	}

}
