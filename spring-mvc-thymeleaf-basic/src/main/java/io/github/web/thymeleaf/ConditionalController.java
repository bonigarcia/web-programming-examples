package io.github.web.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConditionalController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/if")
    public ModelAndView processIf() {
        log.info("GET /if");

        ModelAndView model = new ModelAndView("if_page");
        model.addObject("visible", true);
        model.addObject("hidden", false);

        log.info("Model: {}", model);
        return model;
    }

}
