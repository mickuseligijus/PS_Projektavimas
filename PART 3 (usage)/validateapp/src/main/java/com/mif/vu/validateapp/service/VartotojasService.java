package com.mif.vu.validateapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mif.vu.validateapp.model.Vartotojas;
import com.mif.vu.validateapp.repository.VartotojasRepository;

@Service
public class VartotojasService {
	
	@Autowired
	private VartotojasRepository repository;
	
	public List<Vartotojas> showAll(){
		return (List<Vartotojas>) repository.findAll();
	}
	
	public Vartotojas add(Vartotojas vartotojas) {
		return repository.save(vartotojas);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public void update(long id, String vardas, String pavarde, String numeris, String email, String adresas, String slaptazodis) {
		Vartotojas vartotojas = repository.findById(id).get();
		vartotojas.setAdresas(adresas);
		vartotojas.setEmail(email);
		vartotojas.setPavarde(pavarde);
		vartotojas.setVardas(vardas);
		vartotojas.setSlaptazodis(slaptazodis);
		vartotojas.setTelefonoNumeris(numeris);
		repository.save(vartotojas);
	}
	
	public boolean existsById(long id) {
		
		return repository.existsById(id);
		
	}
	
	public Vartotojas findById(long id) {
		
		return repository.findById(id).get();
		
	}

}
