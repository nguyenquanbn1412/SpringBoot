package com.example.movieapp.service;

import com.example.movieapp.entity.Movie;
import com.example.movieapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebService {
    private final MovieRepository movieRepository;

    public Page<Movie> 
}
