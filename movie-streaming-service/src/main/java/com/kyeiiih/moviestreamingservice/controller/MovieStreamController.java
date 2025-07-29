package com.kyeiiih.moviestreamingservice.controller;

import com.kyeiiih.moviestreamingservice.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movie-stream")
public class MovieStreamController {

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping
    public ResponseEntity<Void> playVideo(@RequestParam String videoUrl) {

        try{
            URI youtubeUri = URI.create(videoUrl);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(youtubeUri)
                    .build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/play-with-id/{videoId}")
    public ResponseEntity<Void> playVideoWithId(@PathVariable Long videoId) {

        String videoUrl = movieCatalogService.getMovieInfoVideoUrl(videoId);
        return playVideo(videoUrl);
    }
}
