package com.example.movieapp.repository;

import com.example.movieapp.entity.History;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository  extends JpaRepository<History, Integer> {
}