package project.carxrental.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Rentanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_rentanje;

    @ManyToOne
    @JoinColumn(name = "embg")
    Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "registracija")
    Vozilo vozilo;

    LocalDate od_koga;
    LocalDate do_koga;

    boolean zavrsheno_rentanje;

    public Rentanje(Korisnik korisnik, Vozilo vozilo, LocalDate od_koga, LocalDate do_koga, boolean zavrsheno_rentanje) {
        this.id_rentanje = id_rentanje;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.od_koga = od_koga;
        this.do_koga = do_koga;
        this.zavrsheno_rentanje = zavrsheno_rentanje;
    }

    public Rentanje() {

    }
}
