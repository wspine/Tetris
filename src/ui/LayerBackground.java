package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {

	//TODO 
	private static  Image IMG_BG=new ImageIcon("graphics/background/bg08.jpg").getImage();
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);		
	}

	@Override
	public void paint(Graphics g) {
		int imgW=IMG_BG.getWidth(null);
		int imgH=IMG_BG.getHeight(null);
		g.drawImage(IMG_BG, 0, 0, 1195, 674, 0, 0, imgW, imgH, null);
		
	}

}
