package io.github.web.thymeleaf;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TextController {

	@RequestMapping("/text")
	public ModelAndView text() {
		MyObject myObject = new MyObject("my name", "my description");
		return new ModelAndView("text_page")
				.addObject("greetings", "Hello world!")
				.addObject("myobj", myObject).addObject("hidden", false);
	}

	@RequestMapping("/iteration")
	public ModelAndView iteration() {
		List<String> colors = Arrays.asList("Red", "Blue", "Green");
		return new ModelAndView("iteration_template").addObject("colors",
				colors);
	}

	@RequestMapping("/processForm1")
	public ModelAndView process(@RequestParam String info) {
		return new ModelAndView("result").addObject("result", info);
	}

	@RequestMapping("/processForm2")
	public ModelAndView process(@ModelAttribute MyForm info) {
		return new ModelAndView("result").addObject("result",
				info.getInfo1() + " and " + info.getInfo2());
	}

}
