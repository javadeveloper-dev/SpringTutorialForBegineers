package com.todoproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.todoproject.entity.Todo;

@SpringBootApplication
@EntityScan("com.todoproject.entity")
@EnableJpaRepositories("com.todoproject.repository")
public class ToDoManagementApplication {
	
	@Bean
	public ModelMapper modelMapper(){
	return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(ToDoManagementApplication.class, args);
	}
}
