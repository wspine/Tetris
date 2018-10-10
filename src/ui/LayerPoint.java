package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {

	private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
	private static final Image IMG_POINT_NUM=new ImageIcon("graphics/string/num.png").getImage();
	private static final int IMG_POINT_NUM_W=IMG_POINT_NUM.getWidth(null)/10 ;
	private static final int IMG_POINT_NUM_H=IMG_POINT_NUM.getHeight(null);
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		//画出外框
		this.createCheek(g);
		//画出“分数”汉纸的图片
		g.drawImage(IMG_POINT, this.x+PADDING, this.y+PADDING, null);
		//显示分数
		int num=this.dto.getNowPoint();
		
		
	}

	private void drawNumber(Graphics g,int num, int x, int y) {
		int imgW=IMG_POINT_NUM.getWidth(null);
		int imgH=IMG_POINT_NUM.getHeight(null);
		g.drawImage(IMG_POINT_NUM,
				this.x+x, this.y+y,
				this.x+PADDING+imgW/10,this.y+2*PADDING+IMG_POINT.getHeight(null)+imgH,
				imgW/10*(num),0,
				imgW/10*(num+1),imgH,
				null);
	
		
	}

}
