package project.carxrental.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.carxrental.model.Lokacija;
import project.carxrental.model.Rentanje;
import project.carxrental.model.Vozilo;
import project.carxrental.repository.RentanjeRepository;
import project.carxrental.service.LokacijaService;
import project.carxrental.service.RentanjeService;
import project.carxrental.service.VoziloService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vozila")
public class VoziloController {

    private final LokacijaService lokacijaService;
    private final VoziloService voziloService;
    private final RentanjeService rentanjeService;

    public VoziloController(LokacijaService lokacijaService, VoziloService voziloService, RentanjeService rentanjeService) {
        this.lokacijaService = lokacijaService;
        this.voziloService = voziloService;
        this.rentanjeService = rentanjeService;
    }

    @GetMapping
    public String GetVoziloPage (Model model){
        model.addAttribute("bodyContent", "vozilo");
        List<Vozilo> vozila = this.voziloService.findAll();
        model.addAttribute("vozila", vozila);
        return "master-template";
    }

    @GetMapping("/add-form")
    public String addVoziloPage(Model model) {
        model.addAttribute("bodyContent", "voziloform");
        List<Vozilo> vozila = voziloService.findAll();
        List<Lokacija> lokacii = lokacijaService.findAll();
        model.addAttribute("locations", lokacii);
        model.addAttribute("vozila", vozila);
        return "master-template"; //View za Add/Edit Products
    }

    @PostMapping("/add") //vozila/add
    public String saveVozilo(@RequestParam String registracija,
                             @RequestParam Integer tip,
                             @RequestParam String brend,
                             @RequestParam String model,
                             @RequestParam String boja,
                             @RequestParam String gorivo,
                             @RequestParam String godina,
                             @RequestParam Integer cena,
                             @RequestParam Integer lokacija){


        this.voziloService.save(registracija, tip, brend, model, boja, gorivo, godina, cena, lokacija);
        return "redirect:/vozila";
    }

    @GetMapping("/edit-form/{registracija}")
    public String editVoziloPage(@PathVariable String registracija, Model model) {
        if(this.voziloService.findById(registracija).isPresent()){
            Vozilo vozilo = this.voziloService.findById(registracija).get();
            List<Lokacija> lokacii = lokacijaService.findAll();
            model.addAttribute("bodyContent", "voziloedit");
            model.addAttribute ("locations", lokacii);
            model.addAttribute("vozilo", vozilo);
            return "master-template"; //View za Add/Edit Products
        }
        return "redirect:/vozilo?error=VoziloNotFound";
    }

    @PostMapping("/delete/{registracija}")
    //@RequestParm products?id=100 || @PathVariable products/67
    public String deleteVoziloPage(@PathVariable String registracija) {
        this.voziloService.deleteById(registracija);
        return "redirect:/vozila";
    }

}
