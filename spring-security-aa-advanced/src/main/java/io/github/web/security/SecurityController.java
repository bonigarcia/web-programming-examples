package io.github.web.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/home")
	public ModelAndView home() {
		// Getting authentication attributes
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		ModelAndView model = new ModelAndView("home").addObject("name", name);

		if (auth.getAuthorities().contains(
				new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			model = model.addObject("admin", true);
		}
		return model;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/root")
	public ModelAndView root() {
		return new ModelAndView("root");
	}

}
