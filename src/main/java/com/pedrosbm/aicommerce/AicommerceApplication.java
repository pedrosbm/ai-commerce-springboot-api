package com.pedrosbm.aicommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class AicommerceApplication {

	@GetMapping
	@ResponseBody
	public String teste(){
		return "Spring boot funcionando";
	} 
	public static void main(String[] args) {
		SpringApplication.run(AicommerceApplication.class, args);
	}

}
