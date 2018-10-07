package entity;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import config.ConfigFactory;

public class DropType {

	
	private Point[] actPoints;
	private static  List<List<Integer>> dropTypeData;
	private int typeCode;
	static {
		dropTypeData=ConfigFactory.getGameConfig().getDropTypeData();		
	}
	
	public DropType() {
		chooseDropType();
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	public int getTypeCode() {
		return typeCode;
	}

	/**
	 * 随机选择下落的类型
	 */
	public void chooseDropType() {		
		Random random=new Random();		
		typeCode=random.nextInt(7);
		
		List<Integer> list=dropTypeData.get(typeCode);
		
		actPoints=new Point[4];		
		for(int i=0;i<actPoints.length;i++) {
			actPoints[i]=new Point(list.get(i<<1),list.get((i<<1)+1));			
		}		
	}
	
	/**
	 * 顺时针旋转90度角
	 */
	public void rotate() {
		if(this.typeCode==6) return;
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
}
