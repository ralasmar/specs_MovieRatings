package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

//implement Movie interface for Batman
@Component
public class TitanicMovie implements Movie{
    //implement getTitle
    public String getTitle(){
        return "Titanic";
    }
    //implement getMaturityRating
    public String getMaturityRating(){
        return "PG-13";
    }
    //implement getGenre
    public String getGenre(){
        return "Romance";
    }

}