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
		//鍒ゆ柇鑳藉惁杩涜涓嬬Щ
		if(!this.dto.isReachBottom()) {
			this.dto.getDropType().moveDown();
		}else {
			//灏嗘姷杈句笅杈圭晫鐨勬柟鍧楀浐鍖栧埌鍫嗙Н鍦板浘涓婇潰
			this.dto.dropTypeBindInMap();
			//			
			this.dto.getDropType().chooseDropType(this.dto.getNext());
			//
			this.dto.setNext(random.nextInt(7));
			
		}		
		//TODO 鍒ゆ柇鏄惁鍙互杩涜娑堣
		//TODO 娑堣鎿嶄綔
		//TODO 绠楀垎鎿嶄綔
		//TODO 鍒ゆ柇鏄惁鍙互杩涜鍗囩骇
		//TODO 鍗囩骇
		//鍒锋柊涓�涓柊鐨勬柟鍧楃被鍨�
				
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
