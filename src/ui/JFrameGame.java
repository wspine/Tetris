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
		
		//���ô��ڵı���
		this.setTitle(cfg.getTitle());
		//���ùر�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//���ò��ɱ䴰��
		this.setResizable(false);
		
		this.setVisible(true);
		//�����ھ���		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int W=screen.width-this.getWidth()>>1;
		int H=(screen.height-this.getHeight()>>1)-cfg.getWindowUp();
		this.setLocation(W,H);
		
		//���Ĭ��panel
		
		this.setContentPane(panel);
	}

}
