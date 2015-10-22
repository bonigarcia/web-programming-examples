package io.github.web.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class I18NController {

	@RequestMapping("/i18n")
	public ModelAndView i18n() {
		return new ModelAndView("i18n_page");
	}

}
