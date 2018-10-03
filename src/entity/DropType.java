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
	 * ˳ʱ����ת90�Ƚ�
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
	
	
	public boolean isReachBottom() {
		for(int i=0;i<actPoints.length;i++) {			
			//TODO  ��������ͼ��Ҳ�����ƶ�
			if(actPoints[i].y+1>17) return true;				
		}
		return false;	
	}
	
	
}
