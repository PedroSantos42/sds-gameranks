package com.pedrosantos.gameranks.dto;

import java.io.Serializable;
import java.time.Instant;

import com.pedrosantos.gameranks.entities.Record;
import com.pedrosantos.gameranks.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public RecordDTO(Record obj) {
        this.id = obj.getId();
        this.moment = obj.getMoment();
        this.name = obj.getName();
        this.age = obj.getAge();
        this.gameTitle = obj.getGame().getTitle();
        this.gamePlatform = obj.getGame().getPlatform();
        this.genreName = obj.getGame().getGenre().getName();
    }
}
