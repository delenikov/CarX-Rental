package project.carxrental.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.carxrental.model.Korisnik;
import project.carxrental.model.Lokacija;
import project.carxrental.model.Vozilo;
import project.carxrental.repository.KorisnikRepository;
import project.carxrental.service.KorisnikService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/korisnici")
public class KorisniciController {

    private final KorisnikService korisnikService;

    public KorisniciController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String GetKorisniciPage(Model model){
        List<Korisnik> korisnici = korisnikService.findAll();
        model.addAttribute("bodyContent", "korisnici");
        model.addAttribute("korisnici", korisnici);
        return "master-template";
    }

    @GetMapping("/add/form")
    public String addKorisnikPage(Model model) {
        model.addAttribute("bodyContent", "addkorisnik");
        return "master-template"; //View za Add/Edit Products
    }

    @PostMapping("/add") //korisnici/add
    public String saveKorisnik(@RequestParam String embg,
                             @RequestParam String ime,
                             @RequestParam String prezime,
                             @RequestParam String pol,
                             @RequestParam String ulica,
                             @RequestParam String broj,
                             @RequestParam Integer vozrast,
                             @RequestParam String datanaraganje,
                             @RequestParam String vozacka,
                             @RequestParam Integer tipkorisnik){
        LocalDate data_na_raganje = LocalDate.parse(datanaraganje);
        this.korisnikService.save(embg, ime, prezime, ulica, broj, pol, vozrast, data_na_raganje, vozacka, tipkorisnik);
        return "redirect:/korisnici";
    }

    @GetMapping("/edit/form/{embg}")
    public String editKorisnikPage(@PathVariable String embg, Model model) {
        if(this.korisnikService.findByEmbg(embg).isPresent()){
            Korisnik korisnik = this.korisnikService.findByEmbg(embg).get();
            model.addAttribute("korisnik", korisnik);
            model.addAttribute("bodyContent", "editkorisnik");
            return "master-template"; //View za Add/Edit Products
        }
        return "redirect:/korisnik?error=InvalidKorisnik";
    }

    //@RequestParm products?id=100 || @PathVariable products/67
    @PostMapping("/delete/{embg}")
    public String deleteKorisnikPage(@PathVariable String embg) {
        this.korisnikService.deleteById(embg);
        return "redirect:/korisnici";
    }
}
