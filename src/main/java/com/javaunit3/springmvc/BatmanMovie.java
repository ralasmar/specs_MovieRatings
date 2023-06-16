package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

//implement Movie interface for Batman
@Component
public class BatmanMovie implements Movie{
    //implement getTitle
    public String getTitle(){
        return "Batman: The Dark Knight";
    }
    //implement getMaturityRating
    public String getMaturityRating(){
        return "PG-13";
    }
    //implement getGenre
    public String getGenre(){
        return "Action";
    }

}