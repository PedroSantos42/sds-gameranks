package com.pedrosantos.gameranks.repositories;

import java.time.Instant;

import com.pedrosantos.gameranks.entities.Record;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT obj FROM Record obj")
    Page<Record> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest);
}
