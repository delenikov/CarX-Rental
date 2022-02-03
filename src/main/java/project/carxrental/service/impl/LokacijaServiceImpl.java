package project.carxrental.service.impl;

import org.springframework.stereotype.Service;
import project.carxrental.model.Lokacija;
import project.carxrental.repository.LokacijaRepository;
import project.carxrental.service.LokacijaService;

import java.util.List;
import java.util.Optional;

@Service
public class LokacijaServiceImpl implements LokacijaService {

    private LokacijaRepository lokacijaRepository;

    public LokacijaServiceImpl(LokacijaRepository lokacijaRepository) {
        this.lokacijaRepository = lokacijaRepository;
    }

    @Override
    public List<Lokacija> findAll() {
        return this.lokacijaRepository.findAll();
    }

    @Override
    public Optional<Lokacija> findById(Integer Id) {
        return this.lokacijaRepository.findById(Id);
    }

}
