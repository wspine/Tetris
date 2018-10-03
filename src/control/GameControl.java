package control;

import service.GameService;
import ui.JPanelGame;

/**
 * ������Ҽ��̿���
 * ���ƻ���
 * ������Ϸ�߼�
 * @author ws
 *
 */
public class GameControl {

	/**
	 * ��Ϸ�����
	 */
	private JPanelGame jPanelGame;
	/**
	 * ��Ϸ�߼���
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
