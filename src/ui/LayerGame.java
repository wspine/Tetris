package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {

	private static Image IMG=new ImageIcon("graphics/game/rect.png").getImage();
	private static int SQU_SIZE=32;
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ���浥������ģ���ˢ�º���
	 */
	public void paint(Graphics g) {
		//ˢ����߿�
		this.createCheek(g);
		//����������		
		int dropType=this.dto.getDropType().getTypeCode();
		this.drawDropType(g,dropType+1);
		//TODO ���ﻭ�ѻ�mapʱ�㷨���ã���Ϊÿ�ƶ�һ����Ҫˢ��������ͼ���ܷ�ʵ��ֻ��ˢ�¾ֲ�
		drawStackedMap(g);
	}
	
	/**
	 * ��������С����
	 * @param g
	 * @param pX
	 * @param pY
	 * @param colorType
	 */
	private void drawSingleCube(Graphics g,int pX,int pY,int  colorType ) {
		g.drawImage(IMG, this.x+SIZE+pX*SQU_SIZE, this.y+SIZE+pY*SQU_SIZE,
				this.x+SIZE+pX*SQU_SIZE+SQU_SIZE, this.y+SIZE+pY*SQU_SIZE+SQU_SIZE,
				SQU_SIZE*colorType, 0, SQU_SIZE*(colorType+1), SQU_SIZE, null);
	}
	
	/**
	 * �������䷽������
	 * @param colorType
	 */
	private void drawDropType(Graphics g, int colorType) {
		Point[] points=this.dto.getDropType().getActPoints();		
		for(int i=0;i<points.length;i++) {
			drawSingleCube(g, points[i].x, points[i].y, colorType);
		}
	}
	
	/**
	 * �����ѻ�map
	 * @param g
	 */
	private void drawStackedMap(Graphics g) {
		boolean map[][]=this.dto.getStackedMap();
		for (int y = 0; y < map[0].length; y++) {
			for(int x=0;x<map.length;x++) {
				if(map[x][y]) drawSingleCube(g, x, y,0);
			}
		}		
	}

	

}
