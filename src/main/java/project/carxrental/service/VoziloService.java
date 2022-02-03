package project.carxrental.service;

import project.carxrental.model.Vozilo;

import java.util.List;
import java.util.Optional;

public interface VoziloService {
    List<Vozilo> findAll();
    void deleteById(String registracija);
    Vozilo findByRegistracija(String registracija);
    List<Vozilo> findAllByLokacija_Ime(String name);
    Optional<Vozilo> findById(String registracija);
    Optional<Vozilo> save(String registracija, Integer tip, String brend, String model, String boja, String gorivo, String godina, Integer cena, Integer idlokacija);
}
