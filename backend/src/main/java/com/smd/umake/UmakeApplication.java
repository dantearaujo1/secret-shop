package com.smd.umake;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UmakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmakeApplication.class, args);
	}

  @GetMapping
  public List<String> makeUps(){
    return List.of("MAC","SEPHORA","Quemdisseberenice");
  }

}
