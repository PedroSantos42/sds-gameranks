package com.pedrosantos.gameranks.repositories;

import com.pedrosantos.gameranks.entities.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
