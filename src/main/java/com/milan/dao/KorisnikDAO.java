package com.milan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.milan.entity.Korisnik;

@Repository
public interface KorisnikDAO extends CrudRepository<Korisnik, Integer>{
	public Korisnik findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
