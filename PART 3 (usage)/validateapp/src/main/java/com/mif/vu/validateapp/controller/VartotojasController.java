package com.mif.vu.validateapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.mif.vu.validateapp.model.Vartotojas;
import com.mif.vu.validateapp.service.ValidationService;
import com.mif.vu.validateapp.service.VartotojasService;

import javassist.compiler.Parser;

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
		System.out.println("Spauskite 2, jei norite redaguoti vartotojo duomenis");
		System.out.println("Spauskite 3, jei norite perziureti vartotoju sarasa");
		System.out.println("Spauskite 4, jei norite perziureti duomenis apie konkretu darbuotoja");
		System.out.println("Spauskite 5, jei norite perziureti funkciju meniu");
		System.out.println("Spauskite 6, jei norite iseiti");
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
				deleteVartotojas();
				printMeniu();
			}
			else if(input.equals("2")) {
				updateVartotojas();
				printMeniu();
			}
			else if(input.equals("3")) {
				showVartotojai();
				printMeniu();
			}
			else if(input.equals("4")) {
				showVartotojas();
				printMeniu();
			}
			else if(input.equals("5")) {
				printMeniu();
			}
			else if(input.equals("6")) {
				//implement
				break;
			}
			else {
				System.out.println("ivedete netinkama simboli!");
			}
		}
	}
	
	public void showVartotojai() {
		List<Vartotojas> vartotojai = vartotojasService.showAll();
		if(vartotojai.size()==0) {
			System.out.println("varotoju sarasas tuscias");
		}
		for(Vartotojas v:vartotojai) {
			System.out.println(v);
		}
	}
	
	public void deleteVartotojas() throws IOException {
		System.out.println("Iveskite varotojo id, kuri norite istrinti");
		String input = reader.readLine();
		long id;
		try {
			id = Long.parseLong(input);
			vartotojasService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
				System.out.println("Nera vartojo su nurodytu id");
				return;
		} catch (NumberFormatException e1) {
			System.out.println("Netinkamas id");
			return;
		}
		System.out.println("Vartotojas sekmingai istrintas");

	}
	
	public int updateVartotojas() throws IOException,NumberFormatException {
		System.out.println("Iveskite varotojo id, kurio duomenis norite redaguoti");
		String input = reader.readLine();
		long id = Long.parseLong(input);
		if(!vartotojasService.existsById(id)) {System.out.println("Nera vartojo su nurodytu id"); return -1;}
		
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
		vartotojasService.update(id, vardas, pavarde, telefonoNr, email, adresas, slaptazodis);
		System.out.println("Vartotojo duomenys sekmingai atnaujinti");
		return 1;
	}
	
	public void showVartotojas() throws IOException {
		System.out.println("Iveskite varotojo id, kurio ieskote");
		String input = reader.readLine();
		try {
			long id = Long.parseLong(input);
			if(!vartotojasService.existsById(id)) {System.out.println("Nera vartojo su nurodytu id"); return;}
			System.out.println(vartotojasService.findById(id));
		}

		  catch (NumberFormatException e1) {
			System.out.println("Netinkamas id");
		}
	}
}
