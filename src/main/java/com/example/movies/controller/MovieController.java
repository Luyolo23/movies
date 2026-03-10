package com.example.movies.controller;

import com.example.movies.dto.MovieDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.movies.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping
    public MovieDTO createAMovie(@Valid @RequestBody MovieDTO dto){
        return movieService.createMovie(dto);
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<MovieDTO> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PutMapping
    public MovieDTO updateMovie( @PathVariable Long id, @Valid @RequestBody MovieDTO dto){
        return movieService.updateMovie(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteeMovie(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}
