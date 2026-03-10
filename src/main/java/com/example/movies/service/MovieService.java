package com.example.movies.service;

import com.example.movies.dto.MovieDTO;
import com.example.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import com.example.movies.model.Movie;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    private MovieDTO convertToDTO(Movie movie){
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getReleaseYear(),
                movie.getRating()
                );
    }

    private Movie convertToEntity(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setDirector(movieDTO.getDirector());
        movie.setReleaseYear(movieDTO.getReleaseYear());
        movie.setRating(movieDTO.getRating());

        return movie;
    }

    // Create a movie
    public MovieDTO createMovie( MovieDTO dto){
        Movie movie = convertToEntity(dto);
        Movie saved = movieRepository.save(movie);

        return convertToDTO(saved);
    }
    // Get all movies
    public List<MovieDTO> getAllMovies(){
        return movieRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Get movie by id
    public MovieDTO getMovieById(Long id){
        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found."));
        return convertToDTO(movie);

    }

    // update movie
    public MovieDTO updateMovie(Long id, MovieDTO dto){
        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found."));
        movie.setTitle(dto.getTitle());
        movie.setDirector(dto.getDirector());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setRating(dto.getRating());

        Movie saved = movieRepository.save(movie);
        return convertToDTO(saved);
    }

    // delete movie by id
    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }
}
