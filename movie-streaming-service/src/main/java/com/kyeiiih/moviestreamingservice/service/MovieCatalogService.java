package com.kyeiiih.moviestreamingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    public static final String MOVIE_CATALOG_SERVICE = "http://movie-catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    public String getMovieInfoVideoUrl(Long movieId) {
      var response =    restTemplate.getForEntity(MOVIE_CATALOG_SERVICE + "/movie-info//find-by-id/{movieId}",
              String.class, movieId);

      return response.getBody();
    }
}
