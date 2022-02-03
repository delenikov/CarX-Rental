package project.carxrental.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Vozilo {

    @Id
    private String registracija;
    private Integer tip; //Motor -1, Avtomobil 0
    private String brend;
    private String model;
    private String boja;
    private String gorivo;
    private String godina;
    private Integer cena;

    @ManyToOne
    @JoinColumn(name = "id_lokacija")
    private Lokacija lokacija;

    public Vozilo(String registracija, Integer tip, String brend, String model, String boja, String gorivo, String godina, Integer cena, Lokacija lokacija) {
        this.registracija = registracija;
        this.tip = tip;
        this.brend = brend;
        this.model = model;
        this.boja = boja;
        this.gorivo = gorivo;
        this.godina = godina;
        this.cena = cena;
        this.lokacija = lokacija;
    }

    public Vozilo() {
    }
}
