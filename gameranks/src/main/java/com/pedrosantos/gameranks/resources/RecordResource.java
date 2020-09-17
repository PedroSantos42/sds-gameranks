package com.pedrosantos.gameranks.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import com.pedrosantos.gameranks.dto.RecordDTO;
import com.pedrosantos.gameranks.dto.RecordInsertDTO;
import com.pedrosantos.gameranks.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("records")
public class RecordResource {
    
    @Autowired
    RecordService service;

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
        @RequestParam(value = "direction", defaultValue = "DESC") String direction,
        @RequestParam(value = "min", defaultValue = "min") String min,
        @RequestParam(value = "max", defaultValue = "max") String max
    ) {
        Instant minDate = (min.equals("")) ? null : Instant.parse(min);
        Instant maxDate = (max.equals("")) ? null : Instant.parse(max);

        if (linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        RecordDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }
}
