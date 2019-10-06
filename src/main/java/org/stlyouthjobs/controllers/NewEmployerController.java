package org.stlyouthjobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.NewEmployer;
import org.stlyouthjobs.models.data.NewEmployerDao;

import javax.validation.Valid;

@Controller
@RequestMapping("newemployer")
public class NewEmployerController {

    @Autowired
    private NewEmployerDao newEmployerDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String employerRegisterForm(Model model) {
        model.addAttribute("organizationName", "Organization Name");
        model.addAttribute("contactName", "Contact Name");
        model.addAttribute("website", "Website");
        model.addAttribute("ein", "EIN");
        model.addAttribute("phoneNumber", "Phone Number");
        model.addAttribute(new NewEmployer());

        return "newemployer/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String employerRegisterForm (Model model, @ModelAttribute @Valid NewEmployer newEmployer, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("organizationName", "Organization Name");
            model.addAttribute("contactName", "Contact Name");
            model.addAttribute("website", "Website");
            model.addAttribute("ein", "EIN");
            model.addAttribute("phoneNumber", "Phone Number");
            return "newemployer/add";
        }
        newEmployerDao.save(newEmployer);
        return "redirect:/addNewJob";
    }

}
