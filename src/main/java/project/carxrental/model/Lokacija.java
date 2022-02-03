package project.carxrental.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Data
@Entity
public class Lokacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_lokacija;
    private String ime;
    private String ulica;
    private String broj;
    private Time rabotno_vreme_od;
    private Time rabotno_vreme_do;

    public Lokacija(String ime, String ulica, String broj, Time rabotno_vreme_od, Time rabotno_vreme_do) {
        this.ime = ime;
        this.ulica = ulica;
        this.broj = broj;
        this.rabotno_vreme_od = rabotno_vreme_od;
        this.rabotno_vreme_do = rabotno_vreme_do;
    }

    public Lokacija() {

    }
}
