package io.github.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public ModelAndView greeting() {

		return new ModelAndView("greeting_template").addObject("name", "World");
	}
}
