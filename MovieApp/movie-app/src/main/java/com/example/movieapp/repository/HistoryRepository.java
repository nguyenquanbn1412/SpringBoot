package com.example.movieapp.repository;

import com.example.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository  extends JpaRepository<Movie, Integer> {
}