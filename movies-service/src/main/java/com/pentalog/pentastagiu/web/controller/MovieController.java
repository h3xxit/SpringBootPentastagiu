package com.pentalog.pentastagiu.web.controller;

import com.pentalog.pentastagiu.service.api.MovieService;
import com.pentalog.pentastagiu.service.dto.MovieDTO;
import com.pentalog.pentastagiu.repository.data.MovieProvider;
import com.pentalog.pentastagiu.web.exception.NoMovieException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Resource
    private MovieService movieService;

    //@RequestMapping("/api/v1/movies")
    //@RequestMapping(value = "/api/v1/movies", method = RequestMethod.GET)
    @GetMapping
    public List<MovieDTO> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO create(@Valid @RequestBody MovieDTO movieDTO) {
        return movieService.create(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String movieId) {
        movieService.delete(movieId);
    }
}
