package com.example.movieapp.repository;

import com.example.movieapp.entity.User;
import com.example.movieapp.model.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(UserRole role);
    Page<User> findByRole(UserRole role, Pageable pageable);
    List<User> findByNameContainingIgnoreCase(String name);
    List<User> findByAvatarNotNull();
    List<User> findByRoleOrderByNameDesc(UserRole role);
    List<User> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
    Page<User> findByRoleOrderByNameDesc(UserRole role, Pageable pageable);

    Long countByRole(UserRole role);
    Boolean existsByEmail(String email);
}
