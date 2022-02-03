package project.carxrental.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Korisnik{

    @Id
    String embg;
    String ime;
    String prezime;
    String ulica;
    String broj;
    String pol;
    Integer vozrast;
    LocalDate datum_na_raganje;
    String vozacka;
    Integer tip_korisnik;

    public Korisnik(String embg, String ime, String prezime, String ulica, String broj, String pol, Integer vozrast, LocalDate datum_na_raganje, String vozacka, Integer tip_korisnik) {
        this.embg = embg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.pol = pol;
        this.vozrast = vozrast;
        this.datum_na_raganje = datum_na_raganje;
        this.vozacka = vozacka;
        this.tip_korisnik = tip_korisnik;
    }

    public Korisnik(){

    }
}
