package io.github.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @RequestMapping("/")
    public ModelAndView processHome() {
        return new ModelAndView("home_page");
    }

    @RequestMapping("/processForm1")
    public ModelAndView processForm1(@RequestParam String input) {
        ModelAndView model = new ModelAndView("result_page");
        model.addObject("result", input);
        return model;
    }

    @RequestMapping("/processForm2")
    public ModelAndView processForm2(@ModelAttribute MyForm info) {
        ModelAndView model = new ModelAndView("result_page");
        model.addObject("result", info.toString());
        return model;
    }
}
