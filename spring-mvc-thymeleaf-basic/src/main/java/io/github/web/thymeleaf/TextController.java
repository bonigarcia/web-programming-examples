package io.github.web.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TextController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/text")
    public ModelAndView processText() {
        log.info("GET /text");

        ModelAndView model = new ModelAndView("text_page");
        model.addObject("greetings", "Hello world!");

        MyObject myObject = new MyObject("My name", "My description");
        model.addObject("myobj", myObject);

        log.info("Model: {}", model);
        return model;
    }

}
