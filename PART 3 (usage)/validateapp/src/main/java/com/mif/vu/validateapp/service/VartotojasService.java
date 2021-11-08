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

}
