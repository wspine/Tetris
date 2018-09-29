package main;

import control.GameControl;
import control.PlayControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		
		//创建游戏数据源
		GameDto dto=new GameDto();
		//创建游戏逻辑，安装游戏数据源
		JPanelGame jPanelGame=new JPanelGame(dto);
		
		GameService service=new GameService(dto);
		//创建游戏控制器（连接游戏面板与逻辑）
		GameControl gameControl= new GameControl(jPanelGame, service);
		//创建玩家控制器（连接游戏控制器）
		PlayControl pcontrol=new PlayControl(gameControl);
		//安装玩家控制
		jPanelGame.setGameControl(pcontrol);		
		new JFrameGame(jPanelGame);			
	}
	
}
