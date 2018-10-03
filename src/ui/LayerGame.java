package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

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
		//��������
		Point[] points=this.dto.getDropType().getActPoints();		
		for(int i=0;i<points.length;i++) {
			drawSingleCube(g, points[i].x, points[i].y, 1);
		}
		//���ѻ�map
		
		
		
	}
	
	private void drawSingleCube(Graphics g,int x,int y,int  colorType ) {
		g.drawImage(IMG, this.x+SIZE+x*SQU_SIZE, this.y+SIZE+y*SQU_SIZE,
				this.x+SIZE+x*SQU_SIZE+SQU_SIZE, this.y+SIZE+y*SQU_SIZE+SQU_SIZE,
				SQU_SIZE*colorType, 0, SQU_SIZE*(colorType), SQU_SIZE, null);
	}

}
