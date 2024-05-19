package com.pedrosbm.aicommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class AicommerceApplication {

	@GetMapping
	public ResponseEntity<String> origin(){
		return ResponseEntity.ok("Aicommerce operante!, acesse a documentação em: http://localhost:8080/swagger-ui/index.html");
	}
	public static void main(String[] args) {
		SpringApplication.run(AicommerceApplication.class, args);
	}

}
