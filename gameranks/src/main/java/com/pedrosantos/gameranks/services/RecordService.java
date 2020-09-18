package com.pedrosantos.gameranks.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.pedrosantos.gameranks.dto.RecordDTO;
import com.pedrosantos.gameranks.dto.RecordInsertDTO;
import com.pedrosantos.gameranks.entities.Game;
import com.pedrosantos.gameranks.entities.Record;
import com.pedrosantos.gameranks.repositories.GameRepository;
import com.pedrosantos.gameranks.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
    
    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoments(minDate, maxDate, pageRequest).map(rec -> new RecordDTO(rec));
	}

    public List<RecordDTO> findAll() {
        List<Record> list = repository.findAll();
        List<RecordDTO> listDto = list.stream().map(rec -> new RecordDTO(rec)).collect(Collectors.toList());
        return listDto;
    }

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
