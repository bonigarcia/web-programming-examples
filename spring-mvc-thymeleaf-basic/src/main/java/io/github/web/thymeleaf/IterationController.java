package io.github.web.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IterationController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/loop")
    public ModelAndView processLoop() {
        log.info("GET /loop");

        ModelAndView model = new ModelAndView("loop_page");
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        model.addObject("colors", colors);

        log.info("Model: {}", model);
        return model;
    }

}
