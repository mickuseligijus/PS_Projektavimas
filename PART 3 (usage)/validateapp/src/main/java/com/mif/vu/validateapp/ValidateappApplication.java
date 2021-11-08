package com.mif.vu.validateapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mif.vu.validateapp.model.Vartotojas;
import com.mif.vu.validateapp.service.ValidationService;
import com.mif.vu.validateapp.service.VartotojasService;

@SpringBootApplication
public class ValidateappApplication implements CommandLineRunner {

	@Autowired
	private ValidationService validationService;
	
	@Autowired 
	private VartotojasService varotojasService;
	
	private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		SpringApplication.run(ValidateappApplication.class, args);
		
	}
	
	@Override
    public void run(String... args) throws IOException {
		
		printMeniu();
		
		while(true) {

			String input = reader.readLine();
			
			if(input.equals("0")) {
				//implement
			}
			else if(input.equals("1")) {
				//implement
			}
			else if(input.equals("2")) {
				//implement
			}
			else if(input.equals("3")) {
				//implement
				break;
			}
			else {
				System.out.println("ivedete netinka simboli!");
			}
		}
	}
	
	public void printMeniu() {
		System.out.println("Spauskite 0, jei norite prideti vartotoja");
		System.out.println("Spauskite 1, jei norite paziureti vartotoju sarasa");
		System.out.println("Spauskite 2 noredami perziureti funkciju meniu");
		System.out.println("Spauskite 3 noredami iseiti");
	}
	
	public void print() throws IOException {

		
		System.out.println("Iveskite Varda");
		String vardas = reader.readLine();
		System.out.println("Iveskite Pavarde");
		String pavarde = reader.readLine();
		System.out.println("Iveskite telefono numeri");
		String telefonoNr = reader.readLine();
		System.out.println("Iveskite email");
		String email = reader.readLine();
		System.out.println("Iveskite adresa");
		String adresas = reader.readLine();
		System.out.println("Iveskite slaptazodi");
		String slaptazodis = reader.readLine();
		Vartotojas v = new Vartotojas(vardas,pavarde,telefonoNr,email,adresas,slaptazodis);
		
		System.out.println(v);
	}
	


}
