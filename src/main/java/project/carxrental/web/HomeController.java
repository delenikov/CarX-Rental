package project.carxrental.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.carxrental.model.Lokacija;
import project.carxrental.service.LokacijaService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final LokacijaService lokacijaService;

    public HomeController(LokacijaService lokacijaService) {
        this.lokacijaService = lokacijaService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("bodyContent", "home");
        List<Lokacija> lokacii = lokacijaService.findAll();
        model.addAttribute ("locations", lokacii);
        return "master-template";
    }

    @PostMapping
    public String selectLocation(@RequestParam Integer location) {
        if (location == 1) {
            return "redirect:/lokacija/kv-rampa";
        }
       else if (location == 2) {
            return "redirect:/lokacija/kv-usje";
        }
        else if (location == 3) {
            return "redirect:/lokacija/aer-ostrovo";
        }
        else if (location == 4) {
            return "redirect:/lokacija/aer-novoLisiche";
        }
        else if (location == 5) {
            return "redirect:/lokacija/taftalidze";
        }
        else {
            return "redirect:/home";
        }
    }
}

