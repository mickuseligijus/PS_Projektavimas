package com.mif.vu.validateapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mif.vu.validateapp.model.Vartotojas;
import com.mif.vu.validateapp.service.ValidationService;
import com.mif.vu.validateapp.service.VartotojasService;

@Component
public class VartotojasController {

	@Autowired
	private ValidationService validationService;
	
	@Autowired 
	private VartotojasService vartotojasService;
	
	private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
	
	public void printMeniu() {
		System.out.println("Spauskite 0, jei norite prideti vartotoja");
		System.out.println("Spauskite 1, jei norite istrinti vartotoja");
		System.out.println("Spauskite 2, jei norite paziureti vartotoju sarasa");
		System.out.println("Spauskite 3 noredami perziureti funkciju meniu");
		System.out.println("Spauskite 4 noredami iseiti");
	}
	
	public int addNewVartotojas() throws IOException {
	
		System.out.println("Iveskite Varda");
		String vardas = reader.readLine();
		System.out.println("Iveskite Pavarde");
		String pavarde = reader.readLine();
		System.out.println("Iveskite telefono numeri");
		String telefonoNr = reader.readLine();
		if(!validationService.validatePhone(telefonoNr)) {
			System.out.println("VALIDATION ERROR:Ivestas netinkamas telefono numeris!");
			return -1;
		}
		System.out.println("Iveskite email");
		String email = reader.readLine();
		if(!validationService.validateEmail(email)) {
			System.out.println("VALIDATION ERROR:Ivestas netinkamas email!");
			return -1;
		}
		System.out.println("Iveskite adresa");
		String adresas = reader.readLine();
		System.out.println("Iveskite slaptazodi");
		String slaptazodis = reader.readLine();
		if(!validationService.validatePassword(slaptazodis)) {
			System.out.println("VALIDATION ERROR:Ivestas netinkamas slaptazodis!");
			return -1;
		}
		Vartotojas vartotojas = vartotojasService.add( new Vartotojas(vardas,pavarde,telefonoNr,email,adresas,slaptazodis));
		System.out.println("Vartotojas sekmingai pridetas: "+ vartotojas);
		
		return 1;
	}
	
	public void start() throws IOException {
		
		printMeniu();
		
		while(true) {

			String input = reader.readLine();
			
			if(input.equals("0")) {
				addNewVartotojas();
				System.out.println();
				printMeniu();
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
}
