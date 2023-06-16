package com.javaunit3.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MovieController {
    //using field injection to set private variables
    @Autowired
    private BestMovieService bestMovieService;

    @Autowired
    private SessionFactory sessionFactory;

    //method getIndexPage with a request mapping of /
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
    //new method with a spring model parameter
    //set request mapping to /bestMovie

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        //add an attribute to the model named "BestMovie" and set it to the movie's title
        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());
        //return string bestMovie which is the corresponding html page
        return "bestMovie";
    }
    //new method with request mapping of voteForBestMovie that returns a string allowing us to load page when we run server
    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieForm(){

        return "voteForBestMovie";
    }
    //new method request mapping that will handle form data
    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie (HttpServletRequest request, Model model){
        //get the submitted movie title from the request
        String movieTitle = request.getParameter("movieTitle");
        //add it to the model
        model.addAttribute("BestMovieVote", movieTitle);
        return "voteForBestMovie";
    }
    //method that returns addMovie to directly to addMovie.html
    @RequestMapping("/addMovieForm")
    public String addMovieFormPage() {
        return "addMovie";
    }
    //method that gets the title, maturity rating, and genre from the request and assign them to local variables
    @RequestMapping("/addMovie")
    public String addMoviePage(HttpServletRequest request, Model model){
        String movieTitle = request.getParameter("movieTitle");
        String maturityRating = request.getParameter("maturityRating");
        String genre = request.getParameter("genre");
        //create new MovieEntity object and set values
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieTitle);
        movieEntity.setMaturityRating(maturityRating);
        movieEntity.setGenre(genre);
        //use session factory to get session object
        Session session = sessionFactory.getCurrentSession();
        //use it to begin transaction
        session.beginTransaction();
        //save object
        session.save(movieEntity);
        //commit transaction
        session.getTransaction().commit();
        return "addMovie";
    }
}
