package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame{
	
	private JPanelGame panel;
	public JFrameGame(JPanelGame panel) {
		
		GameConfig cfg=ConfigFactory.getGameConfig();
		
		//设置窗口的标题
		this.setTitle(cfg.getTitle());
		//设置关闭属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//设置不可变窗口
		this.setResizable(false);
		
		this.setVisible(true);
		//将窗口居中		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int W=screen.width-this.getWidth()>>1;
		int H=(screen.height-this.getHeight()>>1)-cfg.getWindowUp();
		this.setLocation(W,H);
		
		//设计默认panel
		
		this.setContentPane(panel);
	}

}
