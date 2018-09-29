package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {

	private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		this.createCheek(g);
		g.drawImage(IMG_POINT, this.x+PADDING, this.y+PADDING, null);
	}

}
