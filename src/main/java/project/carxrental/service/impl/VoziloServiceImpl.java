package project.carxrental.service.impl;

import org.springframework.stereotype.Service;
import project.carxrental.exceptions.LokacijaNotFoundException;
import project.carxrental.model.Lokacija;
import project.carxrental.model.Vozilo;
import project.carxrental.repository.LokacijaRepository;
import project.carxrental.repository.VoziloRepository;
import project.carxrental.service.VoziloService;

import java.util.List;
import java.util.Optional;

@Service
public class VoziloServiceImpl implements VoziloService {

    private final VoziloRepository voziloRepository;
    private final LokacijaRepository lokacijaRepository;

    public VoziloServiceImpl(VoziloRepository voziloRepository, LokacijaRepository lokacijaRepository) {
        this.voziloRepository = voziloRepository;
        this.lokacijaRepository = lokacijaRepository;
    }

    @Override
    public List<Vozilo> findAll() {
        return this.voziloRepository.findAll();
    }

    @Override
    public void deleteById(String registracija) {
        this.voziloRepository.deleteById(registracija);
    }

    @Override
    public Vozilo findByRegistracija(String registracija) {
        return this.voziloRepository.findByRegistracija(registracija);
    }

    @Override
    public List<Vozilo> findAllByLokacija_Ime(String name) {
        return this.voziloRepository.findAllByLokacija_Ime(name);
    }

    @Override
    public Optional<Vozilo> findById(String registracija) {
        return voziloRepository.findById(registracija);
    }

    @Override
    public Optional<Vozilo> save(String registracija, Integer tip, String brend, String model, String boja, String gorivo, String godina, Integer cena, Integer idlokacija) {
        if(this.voziloRepository.findById(registracija).isPresent()){
            this.voziloRepository.deleteById(registracija);
        }
        Lokacija lokacija = this.lokacijaRepository.findById(idlokacija).orElseThrow(() -> new LokacijaNotFoundException(idlokacija));
        Vozilo newVozilo = new Vozilo(registracija, tip, brend, model, boja, gorivo, godina, cena, lokacija);
        return Optional.of(this.voziloRepository.save(newVozilo));
    }

}
