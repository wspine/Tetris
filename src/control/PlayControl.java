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
		//TODO
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gamecontrol.keyUp();
		break;
		case KeyEvent.VK_DOWN:
			this.gamecontrol.keyDown();
		break;
		case KeyEvent.VK_LEFT:
			this.gamecontrol.keyLeft();
		break;
		case KeyEvent.VK_RIGHT:
			this.gamecontrol.keyRight();
		break;
		default:break;	
		}
	}

}
