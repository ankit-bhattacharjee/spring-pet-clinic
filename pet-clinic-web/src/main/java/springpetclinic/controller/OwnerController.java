package springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springpetclinic.service.OwnerDbService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerDbService ownerDbService;

    public OwnerController(OwnerDbService ownerDbService) {
        this.ownerDbService = ownerDbService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("owners", ownerDbService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }
}
