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
	
	public void paint(Graphics g) {
		this.createCheek(g);
		Point[] points=this.dto.getDropType().getActPoints();
		System.out.println(122);
		for(int i=0;i<points.length;i++) {
			g.drawImage(IMG, this.x+SIZE+points[i].x*SQU_SIZE, this.y+SIZE+points[i].y*SQU_SIZE,
					this.x+SIZE+points[i].x*SQU_SIZE+SQU_SIZE, this.y+SIZE+points[i].y*SQU_SIZE+SQU_SIZE,
					SQU_SIZE, 0, SQU_SIZE*2, SQU_SIZE, null);
		}
		
	}

}
