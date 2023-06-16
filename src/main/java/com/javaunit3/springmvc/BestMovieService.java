package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//define it as Spring Component
@Component

public class BestMovieService {

    private final Movie movie;
    //define private movie property and use Spring annotations so it is autowired
    @Autowired
    //use the qualifier annotation and default bean id for the titanic movie instead of batman
    public BestMovieService(@Qualifier("titanicMovie")Movie movie){
        this.movie = movie;
    }
    //create a constructor that takes a movie as a parameter
//    public BestMovieService(Movie movie){
//        this.movie = movie;
//    }
    //create a setter method that takes a movie object as input
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }


    //define method getBestMovie that returns the movie
    public Movie getBestMovie(){
        return movie;
    }
}