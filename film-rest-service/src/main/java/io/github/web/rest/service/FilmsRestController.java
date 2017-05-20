package io.github.web.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmsRestController {

    @Autowired
    private FilmsService filmsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Film getTeams(
            @RequestParam(value = "t", required = false) String title) {

        System.out.println("Incoming request for film " + title);
        Film out = filmsService.getFilmByTitle(title);
        System.out.println("Response: " + out);

        return out;
    }

}
