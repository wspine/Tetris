package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayControl extends KeyAdapter {

	private GameControl gamecontrol;	
	
	public PlayControl(GameControl gamecontrol) {
		super();
		this.gamecontrol = gamecontrol;
	}


	/**
	 * 键盘按下事件 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.gamecontrol.test(e.getKeyCode());

	}

}
