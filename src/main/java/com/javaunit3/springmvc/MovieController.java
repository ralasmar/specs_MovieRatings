package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;


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
    public String getBestMoviePage(Model model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //get the movie with the most votes
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        movieEntityList.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));

        MovieEntity movieWithMostVotes = movieEntityList.get(movieEntityList.size() - 1);
        List<String> voterNames = new ArrayList<>();

        for (VoteEntity vote: movieWithMostVotes.getVotes()) {
            voterNames.add(vote.getVoterName());
        }

        String voterNamesList = String.join(",", voterNames);
        //populate attributes for the best movie and voter name
        model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("bestMovieVoters", voterNamesList);

        session.getTransaction().commit();

        return "bestMovie";
    }
    //new method with request mapping of voteForBestMovie that returns a string allowing us to load page when we run server
    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieFormPage(Model model) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        //get list of movie entities from database
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();

        session.getTransaction().commit();
        //populate movies attribute with list
        model.addAttribute("movies", movieEntityList);

        return "voteForBestMovie";
    }
    //new method request mapping that will handle form data
    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model) {
        //get movie id and voter name from request
        String movieId = request.getParameter("movieId");
        String voterName = request.getParameter("voterName");

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        //get existing movie from database using movie id
        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setVoterName(voterName);
        //add a new vote to the movie
        movieEntity.addVote(newVote);

        session.update(movieEntity);

        session.getTransaction().commit();

        return "voteForBestMovie";
    }
    //method that returns addMovie to directly to addMovie.html
    @RequestMapping("/addMovieForm")
    public String addMovieForm() {
        return "addMovie";
    }
    //method that gets the title, maturity rating, and genre from the request and assign them to local variables
    @RequestMapping("/addMovie")
    public String addMovie(HttpServletRequest request){
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
