package project.carxrental.service.impl;

import org.springframework.stereotype.Service;
import project.carxrental.model.Korisnik;
import project.carxrental.model.Rentanje;
import project.carxrental.model.Vozilo;
import project.carxrental.repository.RentanjeRepository;
import project.carxrental.service.RentanjeService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentanjeServiceImpl implements RentanjeService {

    RentanjeRepository rentanjeRepository;

    public RentanjeServiceImpl(RentanjeRepository rentanjeRepository) {
        this.rentanjeRepository = rentanjeRepository;
    }

    @Override
    public List<Rentanje> findAll() {
        return this.rentanjeRepository.findAll();
    }

    @Override
    public Optional<Rentanje> findById(Integer Id) {
        return this.rentanjeRepository.findById(Id);
    }

    @Override
    public Optional<Rentanje> findByVozilo_Registracija(String registracija) {
        return this.rentanjeRepository.findByVozilo_Registracija(registracija);
    }

    @Override
    public Optional<Rentanje> save(Korisnik korisnik, Vozilo vozilo, LocalDate od_koga, LocalDate do_koga, boolean zavrsheno_rentanje) {
        if (this.rentanjeRepository.findByVozilo_Registracija(vozilo.getRegistracija()).isPresent()){
            Rentanje rentanje = this.rentanjeRepository.findByVozilo_Registracija(vozilo.getRegistracija()).get();
            this.rentanjeRepository.delete(rentanje);
        }
        Rentanje rentanje = new Rentanje(korisnik, vozilo, od_koga, do_koga, zavrsheno_rentanje);
        return Optional.of(this.rentanjeRepository.save(rentanje));
    }

    @Override
    public void deleteById(Integer Id) {
        this.rentanjeRepository.deleteById(Id);
    }
}
