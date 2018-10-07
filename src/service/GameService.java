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
	
	
	public void keyUp() {
		this.dto.getDropType().rotate();		
	}

	public void keyDown() {
		//判断能否进行下移
		if(!this.dto.isReachBottom()) {
			this.dto.getDropType().moveDown();
		}else {
			//将抵达下边界的方块固化到堆积地图上面
			this.dto.dropTypeBindInMap();
			this.dto.getDropType().chooseDropType();
		}		
		//TODO 判断是否可以进行消行
		//TODO 消行操作
		//TODO 算分操作
		//TODO 判断是否可以进行升级
		//TODO 升级
		//刷新一个新的方块类型
				
	}

	public void keyLeft() {
		this.dto.getDropType().moveLeft();
	}

	public void keyRight() {
		this.dto.getDropType().moveRight();
	}
	
}
