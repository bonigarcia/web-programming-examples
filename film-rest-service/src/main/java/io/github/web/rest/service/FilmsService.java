package io.github.web.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FilmsService {

    private List<Film> films;

    private Film emptyFilm;

    public FilmsService() {
        films = new ArrayList<>();

        // title,year, director, actors, poster, plot, imdbRating, response,
        // error
        films.add(new Film("Interstellar", "2014", "Christopher Nolan",
                "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SY1000_CR0,0,640,1000_AL_.jpg",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "8.6", true, ""));

        films.add(new Film("Avatar", "2009", "James Cameron",
                "Sam Worthington, Zoe Saldana, Sigourney Weaver",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_.jpg",
                "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                "7.8", true, ""));

        // not found film
        emptyFilm = new Film("Not found", "Not found", "Not found", "Not found",
                "https://cdn2.iconfinder.com/data/icons/free-basic-icon-set-2/300/17-256.png",
                "Not found", "Not found", false, "Not found");
    }

    public Film getFilmByTitle(String title) {
        Film out = emptyFilm;
        for (Film f : films) {
            if (f.getTitle().equalsIgnoreCase(title)) {
                out = f;
                break;
            }
        }
        return out;
    }

}
