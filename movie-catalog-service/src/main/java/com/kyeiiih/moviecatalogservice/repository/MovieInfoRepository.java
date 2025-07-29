package com.kyeiiih.moviecatalogservice.repository;

import com.kyeiiih.moviecatalogservice.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {

}

