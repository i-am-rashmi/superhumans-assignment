package com.superhumans.assignment.movieapp.controller;

import com.superhumans.assignment.movieapp.dto.MovieDto;
import com.superhumans.assignment.movieapp.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieServiceImpl mongoService;

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<?> createApiRoute(@RequestBody MovieDto movieDto) {

        mongoService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/movies/search/{prefix}/{limit}", method = RequestMethod.GET)
    public ResponseEntity<?> searchMovies(@PathVariable("prefix") String prefix,@PathVariable("limit") Integer limit) {
        return ResponseEntity.ok(mongoService.findMovieByPrefixAndLimit(prefix,limit));
    }
}
