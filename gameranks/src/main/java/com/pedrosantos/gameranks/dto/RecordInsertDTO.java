package com.pedrosantos.gameranks.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String name;
	private Integer age;
    private Long gameId;
}
