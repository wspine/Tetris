package service;

import java.util.Random;

import dto.GameDto;
import entity.DropType;

public class GameService {

	private GameDto dto;
	private Random random=new Random();

	public GameService(GameDto dto) {
		super();
		this.dto = dto;
		DropType type=new DropType(random.nextInt(7));
		this.dto.setDropType(type);
		this.dto.setNext(random.nextInt(7));
		//TODO 
	}
	
	
	public void keyUp() {
		if(this.dto.isCanRotate()) {
			this.dto.getDropType().rotate();
		}	
	}

	public void keyDown() {
		//判断是否下落到底部
		if(!this.dto.isReachBottom()) {
			this.dto.getDropType().moveDown();
		}else {
			
			this.dto.dropTypeBindInMap();
			//			
			this.dto.getDropType().chooseDropType(this.dto.getNext());
			//
			this.dto.setNext(random.nextInt(7));
			
		}		
		//TODO
		//TODO 
		//TODO 
		//TODO 
		//TODO 
		//
				
	}

	public void keyLeft() {
		if(this.dto.isCanMoveLeft()) {
			this.dto.getDropType().moveLeft();
		}
		
	}

	public void keyRight() {
		if(this.dto.isCanMoveRight()) {
			this.dto.getDropType().moveRight();
		}
	}
	
}
