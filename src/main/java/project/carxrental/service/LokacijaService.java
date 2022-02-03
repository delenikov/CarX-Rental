package project.carxrental.service;

import project.carxrental.model.Lokacija;

import java.util.List;
import java.util.Optional;

public interface LokacijaService {
    List<Lokacija> findAll();
    Optional<Lokacija> findById(Integer Id);
}
