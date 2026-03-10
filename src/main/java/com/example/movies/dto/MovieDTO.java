package com.example.movies.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MovieDTO {
    private Long id;

    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @NotBlank(message = "Director cannot be empty.")
    private String director;

    @NotNull
    @Min(value = 1888, message = "Release year cannot be before 1888.")
    private Integer releaseYear;

    @NotNull
    @Min(0)
    @Max(10)
    private Double rating;

    public MovieDTO(){}

    public MovieDTO(Long id, String title, String director, Integer releaseYear, Double rating){
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    //getters & setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
