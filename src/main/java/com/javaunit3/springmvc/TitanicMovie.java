package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

//implement Movie interface for Batman
@Component
public class TitanicMovie implements Movie{
    //implement getTitle
    @Override
    public String getTitle(){
        return "Titanic";
    }
    //implement getMaturityRating
    @Override
    public String getMaturityRating(){
        return "PG-13";
    }
    //implement getGenre
    @Override
    public String getGenre(){
        return "Romance";
    }

}