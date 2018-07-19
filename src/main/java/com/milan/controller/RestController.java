package com.milan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.milan.entity.Korisnik;
import com.milan.service.KorisnikService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	KorisnikService ks;
	
	
	@GetMapping("/novi-korisnik")
	public String snimiKorisnika(@RequestParam String korisnickoIme, @RequestParam String ime, @RequestParam String prezime, @RequestParam int godina, @RequestParam String lozinka) {
		Korisnik korisnik = new Korisnik(korisnickoIme,ime,prezime,godina,lozinka);
		ks.snimiKorisnika(korisnik);
		return "Korisnik: " + korisnik.getIme() + " " + korisnik.getPrezime() + " je snimljen u bazu podataka";
	}
	
}
