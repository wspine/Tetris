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
	 * 界面单个方框模块的刷新函数
	 */
	public void paint(Graphics g) {
		//刷新外边框
		this.createCheek(g);
		//画下落类型		
		int dropType=this.dto.getDropType().getTypeCode();
		this.drawDropType(g,dropType+1);
		//TODO 这里画堆积map时算法不好，因为每移动一步就要刷新整个地图，能否实现只是刷新局部
		drawStackedMap(g);
	}
	
	/**
	 * 画出单个小方块
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
	 * 画出下落方块类型
	 * @param colorType
	 */
	private void drawDropType(Graphics g, int colorType) {
		Point[] points=this.dto.getDropType().getActPoints();		
		for(int i=0;i<points.length;i++) {
			drawSingleCube(g, points[i].x, points[i].y, colorType);
		}
	}
	
	/**
	 * 画出堆积map
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
