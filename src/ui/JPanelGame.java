package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayControl;
import dto.GameDto;
import service.GameService;

public class JPanelGame extends JPanel {

	private List<Layer> layers=null;
	
	private GameDto dto=null;
	public JPanelGame(GameDto dto) {	
		this.dto=dto;		
		initLayer();
		
	}

	/**
	 * 安装玩家控制器
	 * @param control
	 */
	public void setGameControl(PlayControl control) {
		this.addKeyListener(control);
	}
	
	

	/**
	 * 初始化层
	 */
	private void initLayer() {
		GameConfig cfg=ConfigFactory.getGameConfig();		
		List<LayerConfig> layerConfig=cfg.getLayers();
		layers=new ArrayList<>(layerConfig.size());		
		try {
			
			for(LayerConfig e:layerConfig) {
				Class layerClass=Class.forName(e.getClassName());
				Constructor constructor=layerClass.getConstructor(int.class,int.class,int.class,int.class);
				Layer layer=(Layer) constructor.newInstance(e.getX(),e.getY(),e.getW(),e.getH());
				layer.setDto(this.dto);
				layers.add(layer);
				
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {		
		//调用基类方法
		super.paintComponent(g);
		//绘制游戏界面
		for(Layer e:layers) {
			e.paint(g);
		}
		//返回焦点
		this.requestFocus();		
	}
	
}
