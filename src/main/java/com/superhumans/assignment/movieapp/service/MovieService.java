package com.superhumans.assignment.movieapp.service;

import com.superhumans.assignment.movieapp.dto.MovieDto;

import java.util.Set;

public interface MovieService {
    void createMovie(MovieDto movieDto);
    Set<MovieDto> findMovieByPrefixAndLimit(String prefix, Integer limit);
}
