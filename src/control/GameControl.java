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

	public void test(int keyCode) {
		this.gameService.gameTest(keyCode);
		//swing ���´�ӡҳ��
		this.jPanelGame.repaint();
		
	}

}
