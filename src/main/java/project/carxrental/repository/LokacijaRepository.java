package project.carxrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.carxrental.model.Lokacija;

import java.util.Optional;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Integer> {

}
