package com.superhumans.assignment.movieapp.repository;

import com.superhumans.assignment.movieapp.dto.MovieDto;
import com.superhumans.assignment.movieapp.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    Movie findByName(String name);

//    @Query("{ name:{$regex:?0}}")
//    Set<Movie> searchByPrefixAndLimit(String prefix, PageRequest pageable);
    Page<Movie> findByNameStartingWithIgnoreCase(String regex, Pageable pageable);

}
