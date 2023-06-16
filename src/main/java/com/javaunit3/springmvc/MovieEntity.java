package com.javaunit3.springmvc;

import javax.persistence.*;

//define as a hibernate entity
@Entity
//uses the movies table
@Table(name = "movies")
public class MovieEntity {
    //private integer field id, annotate it so that it is primary key and a generated value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer id;
    //create private fields for title, maturity rating, and genre. annotate and name columns
    @Column(name="title")
    private String title;

    @Column(name="maturityRating")
    private String maturityRating;

    @Column(name="genre")
    private String genre;

    //create getters and setters for all private properties
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getMaturityRating(){
        return maturityRating;
    }
    public void setMaturityRating(String maturityRating){
        this.maturityRating = maturityRating;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
}
