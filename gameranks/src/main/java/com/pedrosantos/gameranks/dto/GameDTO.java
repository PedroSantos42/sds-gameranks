package com.pedrosantos.gameranks.dto;

import java.io.Serializable;

import com.pedrosantos.gameranks.entities.Game;
import com.pedrosantos.gameranks.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String title;
    private Platform plataform;

    public GameDTO(Game obj) {
         this.id = obj.getId();
         this.title = obj.getTitle();
         this.plataform = obj.getPlatform();
    }
}
