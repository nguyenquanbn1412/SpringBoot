package com.example.movieapp.repository;

import com.example.movieapp.entity.Genre;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends JpaRepository<Genre, Integer> {
}
