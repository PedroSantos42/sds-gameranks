package com.pedrosantos.gameranks.services;

import java.time.Instant;

import com.pedrosantos.gameranks.dto.RecordDTO;
import com.pedrosantos.gameranks.dto.RecordInsertDTO;
import com.pedrosantos.gameranks.entities.Game;
import com.pedrosantos.gameranks.entities.Record;
import com.pedrosantos.gameranks.repositories.GameRepository;
import com.pedrosantos.gameranks.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
    
    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);

        entity = repository.save(entity);
        return new RecordDTO(entity);
    }
}
