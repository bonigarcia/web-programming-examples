package io.github.web.rest.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("imdbRating")
    private String rating;

    @JsonProperty("Response")
    private Boolean response;

    @JsonProperty("Error")
    private String error;

    public Film(String title, String year, String director, String actors,
            String poster, String plot, String rating, Boolean response,
            String error) {
        super();
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.poster = poster;
        this.plot = plot;
        this.rating = rating;
        this.response = response;
        this.error = error;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImdbrating() {
        return rating;
    }

    public void setImdbrating(String imdbRating) {
        this.rating = imdbRating;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Film [title=" + title + ", year=" + year + ", director="
                + director + ", actors=" + actors + ", poster=" + poster
                + ", plot=" + plot + ", rating=" + rating + ", response="
                + response + ", error=" + error + "]";
    }

}