package com.pentalog.pentastagiu.repository.data;

import com.pentalog.pentastagiu.service.dto.MovieDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MovieProvider {
    private static HashMap<String, MovieDTO> movies = new HashMap<>();
    static {
        MovieDTO firstMovie = new MovieDTO(UUID.randomUUID().toString(), "The Shawshank Redemption", "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", 10.0);
        MovieDTO secondMovie = new MovieDTO(UUID.randomUUID().toString(), "The Godfather", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,704,1000_AL_.jpg", 8.5);

        movies.put(firstMovie.getId(), firstMovie);
        movies.put(secondMovie.getId(), secondMovie);
    }

    public static List<MovieDTO> getAll() {
        return new ArrayList<>(movies.values());
    }

    public static MovieDTO getById(String id) {
        return movies.get(id);
    }

    public static MovieDTO create(MovieDTO movieDTO) {
        movieDTO.setId(UUID.randomUUID().toString());

        movies.put(movieDTO.getId(), movieDTO);

        return movieDTO;
    }

    public static void delete(String movieId) {
        movies.remove(movieId);
    }
}
