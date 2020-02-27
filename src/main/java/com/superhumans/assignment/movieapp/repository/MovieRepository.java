package com.superhumans.assignment.movieapp.repository;

import com.superhumans.assignment.movieapp.entity.Movie;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    Movie findByName(String name);
    Page<Movie> findByNameStartingWithIgnoreCase(String regex, Pageable pageable);

}
