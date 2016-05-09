package io.github.web.heroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView("home").addObject("users",
                repository.findAll());
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insertAnnouncement(User announcement) {
        repository.save(announcement);
        return new ModelAndView("insert");
    }

    @RequestMapping("/show")
    public ModelAndView showAnnouncement(@RequestParam long userId) {
        return new ModelAndView("show").addObject("user",
                repository.findOne(userId));
    }

    @RequestMapping("/new")
    public ModelAndView newAnnouncement() {
        return new ModelAndView("new");
    }

}