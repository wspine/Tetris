package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

public abstract class Layer {

	protected final static int  SIZE;
	protected final static int PADDING;
	static {
		GameConfig cfg=ConfigFactory.getGameConfig();
		SIZE=cfg.getWindowSize();
		PADDING=cfg.getPadding();
	}
	
	private static Image WINDOW_IMG =new ImageIcon("graphics/window/Window.png").getImage();	
	/**
	 * 绘制边框左上角起点x的坐标
	 */
	protected final int x;
	/**
	 * 绘制边框左上角起点y的坐标
	 */	 
	protected final int y;
	/**
	 * 绘制边框的内宽度
	 */
	protected final int w;
	/**
	 * 边框的内高度
	 */
	protected final int h;
	/**
	 * 游戏数据
	 */
	protected GameDto dto;	
	

	public Layer(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w-(SIZE<<1);
		this.h = h-(SIZE<<1);
	}
	
	protected void createCheek(Graphics g) {			
		int imgW=WINDOW_IMG.getWidth(null);
		int imgH=WINDOW_IMG.getHeight(null);		
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);		
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+SIZE+w,y+SIZE, SIZE, 0, imgW-SIZE, SIZE, null);
		g.drawImage(WINDOW_IMG, x+SIZE+w, y, x+SIZE+w+SIZE,y+SIZE, imgW-SIZE, 0, imgW, SIZE, null);
		g.drawImage(WINDOW_IMG, x+SIZE+w, y+SIZE, x+SIZE+w+SIZE,y+SIZE+h, imgW-SIZE, SIZE, imgW, imgH-SIZE, null);
		g.drawImage(WINDOW_IMG, x+SIZE+w, y+SIZE+h, x+SIZE+w+SIZE,y+SIZE+h+SIZE, imgW-SIZE, imgH-SIZE, imgW, imgH, null);
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE+h, x+SIZE+w,y+SIZE+h+SIZE, SIZE, imgH-SIZE, imgW-SIZE, imgH, null);
		g.drawImage(WINDOW_IMG, x, y+SIZE+h, x+SIZE,y+SIZE+h+SIZE, 0, imgH-SIZE, SIZE, imgH, null);
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE,y+SIZE+h, 0, SIZE, SIZE, imgH-SIZE, null);
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+SIZE+w,y+SIZE+h, SIZE, SIZE,imgW-SIZE, imgH-SIZE, null);
	}
	
	abstract public void paint(Graphics g);
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
}
