package io.github.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @RequestMapping("/")
    public ModelAndView processHome() {
        ModelAndView model = new ModelAndView("home_page");
        return model;
    }

}
