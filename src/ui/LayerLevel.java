package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {

	
	private static final Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();

	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		this.createCheek(g);
		g.drawImage(IMG_LEVEL, this.x+PADDING, this.y+PADDING, null);
	}

}
