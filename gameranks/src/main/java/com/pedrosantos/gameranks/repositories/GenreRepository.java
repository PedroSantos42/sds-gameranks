package com.pedrosantos.gameranks.repositories;

import com.pedrosantos.gameranks.entities.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    
}
