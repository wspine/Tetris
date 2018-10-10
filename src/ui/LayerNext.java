package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {

	private static Image[] IMGS=new Image[7];
	static {
		for(int i=0;i<7;i++) {
			IMGS[i]=new ImageIcon("graphics/game/"+i+".png").getImage();
		}		
	}
	public LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		//画出边框
		this.createCheek(g);
		drawCenterImage(g,IMGS[this.dto.getNext()]);
	}

	/**
	 * 在next框的中心画出下一个的图片
	 * @param g
	 * @param image
	 */
	private void drawCenterImage(Graphics g, Image image) {
		int imgW=image.getWidth(null);
		int imgH=image.getHeight(null);
		int pX=this.x+(this.w>>1)-(imgW>>1);
		int pY=this.y+(this.h>>1)-(imgH>>1);
		g.drawImage(image, pX, pY, null);
		
	}

}
