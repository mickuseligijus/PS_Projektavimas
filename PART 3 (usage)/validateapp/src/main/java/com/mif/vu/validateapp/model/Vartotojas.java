package com.mif.vu.validateapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vartotojas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;

	private String vardas;
	private String pavarde;
	private String telefonoNumeris;
	private String email;
	private String adresas;
	private String slaptazodis;
	
	public Vartotojas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vartotojas(String vardas, String pavarde, String telefonoNumeris, String email, String adresas,
			String slaptazodis) {
		super();
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.telefonoNumeris = telefonoNumeris;
		this.email = email;
		this.adresas = adresas;
		this.slaptazodis = slaptazodis;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVardas() {
		return vardas;
	}
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}
	public String getPavarde() {
		return pavarde;
	}
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	public String getTelefonoNumeris() {
		return telefonoNumeris;
	}
	public void setTelefonoNumeris(String telefonoNumeris) {
		this.telefonoNumeris = telefonoNumeris;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresas() {
		return adresas;
	}
	public void setAdresas(String adresas) {
		this.adresas = adresas;
	}
	public String getSlaptazodis() {
		return slaptazodis;
	}
	public void setSlaptazodis(String slaptazodis) {
		this.slaptazodis = slaptazodis;
	}
	

}
