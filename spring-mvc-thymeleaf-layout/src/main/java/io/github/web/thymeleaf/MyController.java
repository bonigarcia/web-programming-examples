package io.github.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/page1")
    public ModelAndView layout1() {
        return new ModelAndView("page1");
    }

    @RequestMapping(value = "/page2")
    public ModelAndView layout2() {
        return new ModelAndView("page2");
    }

}
