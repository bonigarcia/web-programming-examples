package io.github.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/")
    public ModelAndView greeting() {
        ModelAndView model = new ModelAndView("hello_world");
        model.addObject("name", "World");
        return model;
    }
}
