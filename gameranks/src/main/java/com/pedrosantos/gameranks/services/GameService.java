package com.pedrosantos.gameranks.services;

import java.util.List;
import java.util.stream.Collectors;

import com.pedrosantos.gameranks.dto.GameDTO;
import com.pedrosantos.gameranks.entities.Game;
import com.pedrosantos.gameranks.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> list = repository.findAll();
        List<GameDTO> listDto = list.stream().map(game -> new GameDTO(game)).collect(Collectors.toList());
        return listDto;
    }
}
