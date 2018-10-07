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
	 * ���ѡ�����������
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
	 * ˳ʱ����ת90�Ƚ�
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
	 * �����ƶ�һ��,��Gameservice�д��������ж������кܶ��߼�����
	 */
	public void moveDown() {		
		for(int i=0;i<actPoints.length;i++) actPoints[i].y++;		
	}
	
	
	/**
	 * �����ƶ�һ��
	 */
	public void moveLeft() {		
		if(isCanMoveLeft()) for(int i=0;i<actPoints.length;i++) actPoints[i].x--;		
	}
	
	/**
	 * �����ƶ�һ��
	 */
	public void moveRight() {		
		if(isCanMoveRight()) for(int i=0;i<actPoints.length;i++) actPoints[i].x++;		
	}	
	
	/**
	 * �ж��Ƿ���Խ�������
	 * @return
	 */
	private boolean isCanMoveLeft() {		
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  ��������ͼ��Ҳ�����ƶ�
			if(actPoints[i].x-1<0) return false;				
		}
		return true;	
	}
	
	/**
	 * �ж��Ƿ���Խ�������
	 * @return
	 */
	private boolean isCanMoveRight() {		
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  ��������ͼ��Ҳ�����ƶ�
			if(actPoints[i].x+1>9) return false;				
		}
		return true;	
	}
	

	/**
	 * �ж��Ƿ������ת
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
