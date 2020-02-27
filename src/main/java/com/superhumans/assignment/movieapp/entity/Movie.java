package com.superhumans.assignment.movieapp.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Movie {
    @Id
    public String id;

    @Indexed
    public String name;
}
