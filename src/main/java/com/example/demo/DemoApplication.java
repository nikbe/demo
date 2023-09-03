package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.controller.PostController;
import com.example.model.PostModel;
import com.example.repository.PostRepository;
import com.example.service.PostService;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")

@ComponentScan(basePackageClasses = {PostController.class, 
		PostService.class,PostRepository.class, 
		PostModel.class,
		ApplicationConfig.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

}
