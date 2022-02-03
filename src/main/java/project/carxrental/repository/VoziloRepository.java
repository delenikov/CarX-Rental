package project.carxrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.carxrental.model.Vozilo;

import java.util.List;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, String> {
    List<Vozilo> findAllByLokacija_Ime(String name);
    Vozilo findByRegistracija(String registracija);
}
