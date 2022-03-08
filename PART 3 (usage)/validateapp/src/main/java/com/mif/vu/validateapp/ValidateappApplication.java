package com.mif.vu.validateapp;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mif.vu.validateapp.controller.VartotojasController;

@SpringBootApplication
public class ValidateappApplication implements CommandLineRunner {

	@Autowired
	private VartotojasController vartotojasController;
	
	public static void main(String[] args) {
		SpringApplication.run(ValidateappApplication.class, args);
		
	}
	
	@Override
    public void run(String... args) throws IOException {
		vartotojasController.start();
		
	}
	

	


}
