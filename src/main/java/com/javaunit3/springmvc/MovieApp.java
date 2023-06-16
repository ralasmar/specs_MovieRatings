package com.javaunit3.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//add annotation so the package is scanned for spring components
@ComponentScan
public class MovieApp {
    public static void main(String[] args){
        //get application Context
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class);
        //using application context, get the best movie service using default bean id
        BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);
        //using best movie service get the best movie
        Movie bestMovie = bestMovieService.getBestMovie();
        //print title, maturity rating, and genre of best movie
        System.out.println("Title: " + bestMovie.getTitle());
        System.out.println("Maturity Rating: " + bestMovie.getMaturityRating());
        System.out.println("Genre: " + bestMovie.getGenre());
    }
}
