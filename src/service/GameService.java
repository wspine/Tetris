package service;

import java.awt.Point;

import dto.GameDto;
import entity.DropType;

public class GameService {

	private GameDto dto;

	public GameService(GameDto dto) {
		super();
		this.dto = dto;
		DropType type=new DropType();
		this.dto.setDropType(type);
	}
	
	
	public void keyUp() {
		this.dto.getDropType().rotate();		
	}

	public void keyDown() {
		if(!this.dto.getDropType().isReachBottom()) {
			this.dto.getDropType().moveDown();
		}		
	}

	public void keyLeft() {
		this.dto.getDropType().moveLeft();
	}

	public void keyRight() {
		this.dto.getDropType().moveRight();
	}
	
}
