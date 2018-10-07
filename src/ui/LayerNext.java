package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {

	private static Image[] IMGS;
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
		//»­³ö±ß¿ò
		this.createCheek(g);
	}

}
