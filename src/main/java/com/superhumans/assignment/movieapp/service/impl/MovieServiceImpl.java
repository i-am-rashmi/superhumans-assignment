package com.superhumans.assignment.movieapp.service.impl;

import com.superhumans.assignment.movieapp.dto.MovieDto;
import com.superhumans.assignment.movieapp.entity.Movie;
import com.superhumans.assignment.movieapp.repository.MovieRepository;
import com.superhumans.assignment.movieapp.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void createMovie(MovieDto movieDto) {
        try {
            if (movieRepository.findByName(movieDto.getName()) == null) {
                Movie movie = new Movie();
                movie.setName(movieDto.getName());
                movieRepository.save(movie);
            }
        }catch(Exception e){

        }

    }

    @Override
    public Set<MovieDto> findMovieByPrefixAndLimit(String prefix, Integer limit) {

        Set<Movie> movieList = movieRepository.findByNameStartingWithIgnoreCase(prefix,PageRequest.of(0,limit,Sort.by(Sort.Direction.ASC,"name"))).toSet();
        Set<MovieDto> movieDtoSet = new HashSet<>();
        if(!movieList.isEmpty()) {
            for (Movie m : movieList) {
                MovieDto movieDto = new MovieDto();
                movieDto.setName(m.getName());
                movieDtoSet.add(movieDto);
            }
        }
        return movieDtoSet;
    }
}
