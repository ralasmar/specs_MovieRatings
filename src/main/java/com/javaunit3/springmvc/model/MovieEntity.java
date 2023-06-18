//package com.javaunit3.springmvc.model;
//
//import com.javaunit3.springmvc.model.VoteEntity;
//
//import javax.persistence.*;
//import java.util.List;
//
////define as a hibernate entity
//@Entity
////uses the movies table
//@Table(name = "movies")
//public class MovieEntity {
//    //private integer field id, annotate it so that it is primary key and a generated value
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="movie_id")
//    private Integer id;
//    //create private fields for title, maturity rating, and genre. annotate and name columns
//    @Column(name="title")
//    private String title;
//
//    @Column(name="maturityRating")
//    private String maturityRating;
//
//    @Column(name="genre")
//    private String genre;
//
//
//    //indicate a one to many mapping and join column
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "movie_id")
//    private List<VoteEntity> votes;
//
//    public List<VoteEntity> getVotes()
//    {
//        return votes;
//    }
//
//    public void setVotes(List<VoteEntity> votes)
//    {
//        this.votes = votes;
//    }
//
//    public void addVote(VoteEntity vote)
//    {
//        this.votes.add(vote);
//    }
//
//    //create getters and setters for all private properties
//    public String getTitle(){
//        return title;
//    }
//    public void setTitle(String title){
//        this.title = title;
//    }
//    public String getMaturityRating(){
//        return maturityRating;
//    }
//    public void setMaturityRating(String maturityRating){
//        this.maturityRating = maturityRating;
//    }
//    public String getGenre(){
//        return genre;
//    }
//    public void setGenre(String genre){
//        this.genre = genre;
//    }
//    public Integer getId(){
//        return id;
//    }
//    public void setId(Integer id){
//        this.id = id;
//    }
//
//}
package com.javaunit3.springmvc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "maturity_rating")
    private String maturityRating;

    @Column(name = "genre")
    private String genre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<VoteEntity> votes;

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    public void addVote(VoteEntity vote) {
        this.votes.add(vote);
    }
    public String getMaturityRating() {
        return maturityRating;
    }
    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
