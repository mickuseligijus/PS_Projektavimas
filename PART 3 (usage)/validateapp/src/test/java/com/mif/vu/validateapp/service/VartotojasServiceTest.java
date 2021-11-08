package com.mif.vu.validateapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mif.vu.validateapp.model.Vartotojas;
import com.mif.vu.validateapp.repository.VartotojasRepository;

@ExtendWith(MockitoExtension.class)
class VartotojasServiceTest {

	@Mock
	private VartotojasRepository repository;
	
	@InjectMocks
	private VartotojasService service;
	
	@Test
	void testShowAll() {
		Vartotojas v = new Vartotojas("Tadas","Savickis","862138041","test@email.com","ukmerges g 8","trinkUstr51");
		List<Vartotojas> l = new ArrayList<>();
		l.add(v);
		
		when(repository.findAll()).thenReturn(l);
		List<Vartotojas> found = service.showAll();
		
		verify(repository).findAll();
		assertEquals(1,found.size());	
			
	}
	
	@Test
	void testUpdate() {
		Vartotojas v = new Vartotojas("Tadas","Savickis","862138041","test@email.com","ukmerges g 8","trinkUstr51");
		service.update(v.getId(),v.getVardas(),v.getPavarde(),v.getTelefonoNumeris(),v.getEmail(),v.getAdresas(),v.getSlaptazodis());
		verify(repository).save(Mockito.any(Vartotojas.class));
	}
	
	@Test
	void testAdd() {
		Vartotojas v = new Vartotojas("Tadas","Savickis","862138041","test@email.com","ukmerges g 8","trinkUstr51");
		when(repository.save(Mockito.any(Vartotojas.class))).thenReturn(v);
		
		Vartotojas added = service.add(v);
		verify(repository).save(Mockito.any(Vartotojas.class));
		assertNotNull(added);
	}
	
	@Test
	void testDeleteById() {
		service.deleteById(Mockito.anyLong());
		verify(repository).deleteById(Mockito.anyLong());
	}


}
