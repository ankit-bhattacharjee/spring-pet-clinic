package springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springpetclinic.service.VetDbService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetDbService vetDbService;

    public VetController(VetDbService vetDbService) {
        this.vetDbService = vetDbService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("vets", vetDbService.findAll());
        return "vets/index";
    }
}
