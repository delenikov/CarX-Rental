package project.carxrental.service;

import project.carxrental.model.Korisnik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    List<Korisnik> findAll();
    void deleteById(String embg);
    Optional<Korisnik> findByEmbg(String embg);
    Optional<Korisnik> save(String embg, String ime, String prezime, String ulica, String broj, String pol, Integer vozrast, LocalDate datum_na_raganje, String vozacka, Integer tip_korisnik);
}
