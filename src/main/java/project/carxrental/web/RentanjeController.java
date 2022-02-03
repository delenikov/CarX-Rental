package project.carxrental.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.carxrental.model.Korisnik;
import project.carxrental.model.Rentanje;
import project.carxrental.model.Vozilo;
import project.carxrental.repository.KorisnikRepository;
import project.carxrental.service.KorisnikService;
import project.carxrental.service.LokacijaService;
import project.carxrental.service.RentanjeService;
import project.carxrental.service.VoziloService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rentanja")
public class RentanjeController {

    private final LokacijaService lokacijaService;
    private final VoziloService voziloService;
    private final RentanjeService rentanjeService;
    private final KorisnikService korisnikService;

    public RentanjeController(LokacijaService lokacijaService, VoziloService voziloService, RentanjeService rentanjeService, KorisnikService korisnikService) {
        this.lokacijaService = lokacijaService;
        this.voziloService = voziloService;
        this.rentanjeService = rentanjeService;
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String GetRentaniVozilaPage(Model model) {
        List<Rentanje> rentanjaList = this.rentanjeService.findAll();
        //rentanjaList.get(1).getVozilo().getLokacija();
        model.addAttribute("rentanja", rentanjaList);
        model.addAttribute("bodyContent", "RentaniVozila");
        return "master-template";
    }

    @GetMapping("/zadocneti")
    public String GetZadocnetiVozilaPage(Model model) {
        List<Rentanje> siteRentanja = this.rentanjeService.findAll();
        List<Rentanje> zadocnetiRentanja = new ArrayList<>();
        for (Rentanje r : siteRentanja) {
            if (!r.getDo_koga().isAfter(LocalDate.now()) && !r.isZavrsheno_rentanje()) {
                zadocnetiRentanja.add(r);
            }
        }
        if (!zadocnetiRentanja.isEmpty()) {
            model.addAttribute("zadocnetiRentanja", zadocnetiRentanja);
        }
        model.addAttribute("bodyContent", "zadocnetiRentanja");
        return "master-template";
    }

    @GetMapping("/add/form")
    public String addRentanjePage(Model model) {
        model.addAttribute("bodyContent", "addrentanje");
        List<Vozilo> vozila = voziloService.findAll();
        List<Vozilo> dostapniVozila = new ArrayList<>();
        List<Korisnik> korisnici = this.korisnikService.findAll();

        for (Vozilo v : vozila) {
            if (!this.rentanjeService.findByVozilo_Registracija(v.getRegistracija()).isPresent()) {
                dostapniVozila.add(v);
            } else if (this.rentanjeService.findByVozilo_Registracija(v.getRegistracija()).isPresent() &&
                    this.rentanjeService.findByVozilo_Registracija(v.getRegistracija()).get().isZavrsheno_rentanje()) {
                dostapniVozila.add(v);
            }
        }
        if (!dostapniVozila.isEmpty()) {
            model.addAttribute(model.addAttribute("vozila", dostapniVozila));
        }
        if (!korisnici.isEmpty()) {
            model.addAttribute(model.addAttribute("korisnici", korisnici));
        }
        return "master-template";
    }

    @PostMapping("/add")
    public String saveRentanje(@RequestParam (required = false) Integer Id,
                               @RequestParam String embg,
                               @RequestParam String registracija,
                               @RequestParam String dokoga,
                               @RequestParam String odkoga,
                               @RequestParam (required = false) String dalieZavrsenoRentanje) {

        boolean zavrsenoRentanje = Boolean.parseBoolean(dalieZavrsenoRentanje);
        Korisnik korisnik = this.korisnikService.findByEmbg(embg).get();
        Vozilo vozilo = this.voziloService.findByRegistracija(registracija);
        LocalDate do_koga = LocalDate.parse(dokoga);
        LocalDate od_koga = LocalDate.parse(odkoga);
        this.rentanjeService.save(korisnik, vozilo, od_koga, do_koga, zavrsenoRentanje);
        return "redirect:/rentanja";
    }

    @GetMapping("/edit/{id}")
    public String editRentanjePage(@PathVariable Integer id, Model model) {
        if(this.rentanjeService.findById(id).isPresent()){
            model.addAttribute("bodyContent", "editrentanje");
            Rentanje rentanje = this.rentanjeService.findById(id).get();

            model.addAttribute("rentanje", rentanje);
            return "master-template";
        }
        return "redirect:/rentanje?error=RentanjeNotFound";
    }

    @PostMapping("/delete/{id}")
    public String deleteRentanjePage(@PathVariable Integer id) {
        this.rentanjeService.deleteById(id);
        return "redirect:/rentanja";
    }


}
