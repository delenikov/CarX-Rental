package project.carxrental.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Servis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_servis;
    @ManyToOne
    @JoinColumn(name = "registracija")
    Vozilo vozilo;
    Date datum;
    String vid;

    public Servis(Integer id_servis, Vozilo vozilo, Date datum, String vid) {
        this.id_servis = id_servis;
        this.vozilo = vozilo;
        this.datum = datum;
        this.vid = vid;
    }

    public Servis(){

    }
}
