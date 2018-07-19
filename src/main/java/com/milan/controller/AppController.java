package com.milan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.milan.entity.Korisnik;
import com.milan.service.KorisnikService;

@Controller
public class AppController {
	
	@Autowired
	KorisnikService ks;
	
	
	@RequestMapping("/")
	public String dobroDosli(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_POCETNA");
		return "index";
	}
	
	@RequestMapping("/pocetna")
	public String prikaziPocetnu(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_POCETNA");
		return "index";
	}
	
	@RequestMapping("/novi_korisnik")
	public String noviKorisnik(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTRACIJA");
		return "index";
	}
	
	@RequestMapping("/svi_korsnici")
	public String sviKorisnici(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("korisnik") != null) {
			request.setAttribute("korisnici", ks.sviKorisnici());
			request.setAttribute("mode", "MODE_PRIKAZKORISNIKA");
		}else {
			request.setAttribute("mode", "MODE_LOGIN");
		}
		
		
		return "index";
	}
	
	@RequestMapping(value="/snimi_korisnika", method=RequestMethod.POST)
	public String snimiKorisnika(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
		ks.snimiKorisnika(korisnik);
		request.setAttribute("mode", "MODE_POCETNA");
		return "index";
	}
	
	@RequestMapping("/obrisi_korisnika")
	public String obrisiKorisnika(@RequestParam int id, HttpServletRequest request) {
		ks.obrisiKorisnika(id);
		request.setAttribute("korisnici", ks.sviKorisnici());
		request.setAttribute("mode", "MODE_PRIKAZKORISNIKA");
		return "index";
	}
	
	@RequestMapping("/prikazi_korisnika")
	public String prikaziKorisnika(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("korisnik", ks.dajKorisnika(id));
		request.setAttribute("mode", "MODE_IZMENA");
		return "index";
	}
	
	@RequestMapping(value="/snimi_izmenu", method=RequestMethod.POST)
	public String snimiIzmenuKorisnika(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
		ks.snimiKorisnika(korisnik);
		request.setAttribute("korisnici", ks.sviKorisnici());
		request.setAttribute("mode", "MODE_PRIKAZKORISNIKA");
		return "index";
	}
	
	@RequestMapping("/login")
	public String prikaziKorisnika(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "index";
	}
	
	@RequestMapping(value="/provera_korisnika", method=RequestMethod.POST)
	public String proveriKorisnika(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
		if(ks.proveriKorisnika(korisnik.getKorisnickoIme(), korisnik.getLozinka()) != null) {
			request.setAttribute("mode", "MODE_POCETNA");
			HttpSession session = request.getSession();
			session.setAttribute("korisnik", korisnik);
		} else {
			request.setAttribute("mode", "MODE_LOGIN");
			request.setAttribute("error", "Корисничко име или лозинка нису тачни");
		}	
		
		return "index";
	}
	
	
	
	
	

}
