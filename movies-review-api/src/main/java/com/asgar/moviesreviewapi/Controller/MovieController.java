package com.asgar.moviesreviewapi.Controller;

import com.asgar.moviesreviewapi.Entity.Movie;
import com.asgar.moviesreviewapi.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/movieId/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable ObjectId id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovieByImdbId(@PathVariable String imdbId){

        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId),HttpStatus.OK);
    }


}
