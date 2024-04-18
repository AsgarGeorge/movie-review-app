package com.asgar.moviesreviewapi.Service;


import com.asgar.moviesreviewapi.Entity.Movie;
import com.asgar.moviesreviewapi.Repo.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository ;


    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }


    public Movie getMovieById(ObjectId id) {

        return movieRepository.findById(id).get();
    }

    public Movie getMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId).get();
    }
}
