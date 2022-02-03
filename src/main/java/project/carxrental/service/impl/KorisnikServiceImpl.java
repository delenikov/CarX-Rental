package project.carxrental.service.impl;

import org.springframework.stereotype.Service;
import project.carxrental.model.Korisnik;
import project.carxrental.repository.KorisnikRepository;
import project.carxrental.service.KorisnikService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Korisnik> findAll() {
        return this.korisnikRepository.findAll();
    }

    @Override
    public void deleteById(String embg) {
        this.korisnikRepository.deleteById(embg);
    }

    @Override
    public Optional<Korisnik> findByEmbg(String embg) {
        return this.korisnikRepository.findById(embg);
    }

    @Override
    public Optional<Korisnik> save(String embg, String ime, String prezime, String ulica, String broj, String pol, Integer vozrast, LocalDate datum_na_raganje, String vozacka, Integer tip_korisnik) {
        if (this.korisnikRepository.findById(embg).isPresent()){
            this.korisnikRepository.deleteById(embg);
        }
        Korisnik korisnik = new Korisnik(embg, ime, prezime, ulica, broj, pol, vozrast, datum_na_raganje, vozacka, tip_korisnik);
        return  Optional.of(this.korisnikRepository.save(korisnik));
    }

}
