package com.kyeiiih.moviecatalogservice.controller;

import com.kyeiiih.moviecatalogservice.model.MovieInfo;
import com.kyeiiih.moviecatalogservice.repository.MovieInfoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movie-info")
@RestController
public class MovieInfoController {

    private final MovieInfoRepository movieInfoRepository;

    public MovieInfoController(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    @PostMapping("/save-all")
    public List<MovieInfo> saveAllMovieInfo(
          @RequestBody List<MovieInfo> movieInfos
    ) {
       return movieInfoRepository.saveAll(movieInfos);
    }

    @GetMapping("/list-all")
    public List<MovieInfo> listAllMovieInfo(
            ) {
        return movieInfoRepository.findAll();
    }

    @GetMapping("/find-by-id/{movieId}")
    public String findMovieVideoUrlById(
            @PathVariable Long movieId
    ) {
        MovieInfo movieInfo = movieInfoRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + movieId));

        return movieInfo.getVideoUrl();
    }
}
