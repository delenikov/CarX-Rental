package project.carxrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.carxrental.model.Rentanje;
import project.carxrental.model.Vozilo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentanjeRepository extends JpaRepository<Rentanje, Integer> {
    Optional<Rentanje> findByVozilo_Registracija(String registracija);
}
