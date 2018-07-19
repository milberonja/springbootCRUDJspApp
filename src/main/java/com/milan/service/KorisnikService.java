package com.milan.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milan.dao.KorisnikDAO;
import com.milan.entity.Korisnik;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikDAO korisnikDao;
	
	public void snimiKorisnika(Korisnik korisnik) {
		korisnikDao.save(korisnik);		
	}
	
	public List<Korisnik> sviKorisnici(){
		List<Korisnik> korisnici = new ArrayList<>();
		for(Korisnik korisnik : korisnikDao.findAll()) {
			korisnici.add(korisnik);
		}
		//korisnici.sort(Comparator.comparing(Korisnik::getId));
		Collections.sort(korisnici, Comparator.comparingInt(Korisnik::getId).reversed());
		return korisnici;
	}
	
	public void obrisiKorisnika(int id) {
		korisnikDao.deleteById(id);
	}

	public Korisnik dajKorisnika(int id) {
		Optional<Korisnik> optional = korisnikDao.findById(id);
		Korisnik korisnik = optional.get();
		return korisnik;
	}
	
	public Korisnik proveriKorisnika(String korisnickoIme, String lozinka) {
		return korisnikDao.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
	}
}
