package service;

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

	public void gameTest(int keyCode) {
		this.dto.setNowPoint(keyCode);		
	}
	
	
}
