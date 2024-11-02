package com.example.ParcialPractico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ParcialPracticoApplication {

	@GetMapping("/samu")
   public String samu(){
       return "Hola ";
   }

	public static void main(String[] args) {
		SpringApplication.run(ParcialPracticoApplication.class, args);
	}

}
