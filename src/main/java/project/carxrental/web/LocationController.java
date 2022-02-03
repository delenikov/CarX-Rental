package project.carxrental.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.carxrental.model.Lokacija;
import project.carxrental.model.Vozilo;
import project.carxrental.service.LokacijaService;
import project.carxrental.service.VoziloService;
import java.util.List;

@Controller
@RequestMapping("/lokacija")
public class LocationController {

    private final VoziloService voziloService;
    private final LokacijaService lokacijaService;

    public LocationController(VoziloService voziloService, LokacijaService lokacijaService) {
        this.voziloService = voziloService;
        this.lokacijaService = lokacijaService;
    }

    @GetMapping("/kv-rampa")
    public String getRampaPage(Model model) {
        String lokacija = "Kisela Voda-Rampa";
        List<Vozilo> vozilaNaLokacija = this.voziloService.findAllByLokacija_Ime(lokacija);
        model.addAttribute("lokacija", lokacija);
        model.addAttribute("vozila", vozilaNaLokacija);
        model.addAttribute("bodyContent", "lokacija");
        return "master-template";
    }
    @GetMapping("/kv-usje")
    public String getUsjePage(Model model) {
        String lokacija = "Kisela Voda-USJE";
        List<Vozilo> vozilaNaLokacija = this.voziloService.findAllByLokacija_Ime(lokacija);
        model.addAttribute("lokacija", lokacija);
        model.addAttribute("vozila", vozilaNaLokacija);
        model.addAttribute("bodyContent", "lokacija");
        return "master-template";
    }
    @GetMapping("/taftalidze")
    public String getTaftalidzePage(Model model) {
        String lokacija = "Taftalidze";
        List<Vozilo> vozilaNaLokacija = this.voziloService.findAllByLokacija_Ime(lokacija);
        model.addAttribute("lokacija", lokacija);
        model.addAttribute("vozila", vozilaNaLokacija);
        model.addAttribute("bodyContent", "lokacija");
        return "master-template";
    }
    @GetMapping("/aer-ostrovo")
    public String getOstrovoPage(Model model) {
        String lokacija = "Aerodrom Ostrovo";
        List<Vozilo> vozilaNaLokacija = this.voziloService.findAllByLokacija_Ime(lokacija);
        model.addAttribute("lokacija", lokacija);
        model.addAttribute("vozila", vozilaNaLokacija);
        model.addAttribute("bodyContent", "lokacija");
        return "master-template";
    }
    @GetMapping("/aer-novoLisiche")
    public String getLisichePage(Model model) {
        String lokacija = "Novo Lisice";
        List<Vozilo> vozilaNaLokacija = this.voziloService.findAllByLokacija_Ime(lokacija);
        model.addAttribute("lokacija", lokacija);
        model.addAttribute("vozila", vozilaNaLokacija);
        model.addAttribute("bodyContent", "lokacija");
        return "master-template";
    }

}
