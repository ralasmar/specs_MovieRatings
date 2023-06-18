package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//define a spring bean method that returns hibernate SessionFactory
@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory getFactory(){
        SessionFactory factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                //add MovieEntity as an annotated class to SessionFactory
                .addAnnotatedClass(MovieEntity.class)
                //add VoteEntity as annotated class
                .addAnnotatedClass(VoteEntity.class)
                .buildSessionFactory();
        return factory;
    }
}