package springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springpetclinic.model.Owner;
import springpetclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
        if (owner.getLastName() == null)
            owner.setLastName("");
        List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        owners.forEach(System.out::println);
        if (owners.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (owners.size() == 1)
            return "redirect:/owners/" + owners.get(0).getId();
        else {
            model.addAttribute("selections", owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping("/new")
    public String initCreateOwnerForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/createOrUpdateOwner";
    }

    @PostMapping("/new")
    public String processCreateOwnerForm(@Valid Owner owner, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "owners/createOrUpdateOwner";
        return "redirect:/owners/" + ownerService.save(owner).getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/createOrUpdateOwner";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult bindingResult
            , @PathVariable Long ownerId) {
        if (bindingResult.hasErrors())
            return "owners/createOrUpdateOwner";
        owner.setId(ownerId);
        return "redirect:/owners/" + ownerService.save(owner).getId();
    }
}