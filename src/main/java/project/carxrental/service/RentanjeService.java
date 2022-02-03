package project.carxrental.service;

import project.carxrental.model.Korisnik;
import project.carxrental.model.Rentanje;
import project.carxrental.model.Vozilo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentanjeService {
    List<Rentanje> findAll();
    Optional<Rentanje> findById(Integer Id);
    Optional<Rentanje> findByVozilo_Registracija(String registracija);
    Optional<Rentanje> save(Korisnik korisnik, Vozilo vozilo, LocalDate od_koga, LocalDate do_koga, boolean zavrsheno_rentanje);
    void deleteById(Integer Id);
}
