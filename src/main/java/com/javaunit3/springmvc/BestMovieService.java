package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//define it as Spring Component
@Component
public class BestMovieService {
    private Movie movie;
    //define private movie property and use Spring annotations so it is autowired
    @Autowired
    //use the qualifier annotation and default bean id for the titanic movie instead of batman
    public BestMovieService(@Qualifier("titanicMovie")Movie movie){
        this.movie = movie;
    }

    //define method getBestMovie that returns the movie
    public Movie getBestMovie(){
        return movie;
    }
}