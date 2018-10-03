package entity;

import java.awt.Point;

public class DropType {

	
	private Point[] actPoints;
	
	
	public DropType() {
		actPoints=new Point[] {
		new Point(4, 0),
		new Point(3, 0),		
		new Point(5, 0),
		new Point(5, 1)		
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	
	
	/**
	 * 顺时针旋转90度角
	 */
	public void rotate() {
		if(isCanRotate()) {
			for (int i = 0; i < actPoints.length; i++) {
				int pX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
				int pY=actPoints[0].y-actPoints[0].x+actPoints[i].x;			
				actPoints[i].x=pX;
				actPoints[i].y=pY;
			}
		}		
	}
	

	/**
	 * 向下移动一步,在Gameservice中处理下落判定，还有很多逻辑处理
	 */
	public void moveDown() {		
		for(int i=0;i<actPoints.length;i++) actPoints[i].y++;		
	}
	
	
	/**
	 * 向左移动一步
	 */
	public void moveLeft() {		
		if(isCanMoveLeft()) for(int i=0;i<actPoints.length;i++) actPoints[i].x--;		
	}
	
	/**
	 * 向右移动一步
	 */
	public void moveRight() {		
		if(isCanMoveRight()) for(int i=0;i<actPoints.length;i++) actPoints[i].x++;		
	}	
	
	/**
	 * 判断是否可以进行左移
	 * @return
	 */
	private boolean isCanMoveLeft() {		
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  触碰到地图是也不能移动
			if(actPoints[i].x-1<0) return false;				
		}
		return true;	
	}
	
	/**
	 * 判断是否可以进行右移
	 * @return
	 */
	private boolean isCanMoveRight() {		
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  触碰到地图是也不能移动
			if(actPoints[i].x+1>9) return false;				
		}
		return true;	
	}
	

	/**
	 * 判断是否可以旋转
	 * @return
	 */
	private boolean isCanRotate() {
		for (int i = 0; i < actPoints.length; i++) {
			int pX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int pY=actPoints[0].y-actPoints[0].x+actPoints[i].x;			
			if(pX<0||pX>9||pY<0||pY>17) return false;
		}
		return true;
	}
	
	
	public boolean isReachBottom() {
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  触碰到地图是也不能移动
			if(actPoints[i].y+1>17) return true;				
		}
		return false;	
	}
	
	
}
