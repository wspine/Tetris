package control;

import service.GameService;
import ui.JPanelGame;

/**
 * 接受玩家键盘控制
 * 控制画面
 * 控制游戏逻辑
 * @author ws
 *
 */
public class GameControl {

	/**
	 * 游戏界面层
	 */
	private JPanelGame jPanelGame;
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame jPanelGame,GameService gameService) {
		this.jPanelGame=jPanelGame;
		this.gameService=gameService;
	}

	public void keyUp() {
		this.gameService.keyUp();
		this.jPanelGame.repaint();		
	}

	public void keyDown() {
		this.gameService.keyDown();
		this.jPanelGame.repaint();
	}

	public void keyLeft() {
		this.gameService.keyLeft();
		this.jPanelGame.repaint();
	}

	public void keyRight() {
		this.gameService.keyRight();
		this.jPanelGame.repaint();
	}


}
