package main;

import control.GameControl;
import control.PlayControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		
		//������Ϸ����Դ
		GameDto dto=new GameDto();
		//������Ϸ�߼�����װ��Ϸ����Դ
		JPanelGame jPanelGame=new JPanelGame(dto);
		
		GameService service=new GameService(dto);
		//������Ϸ��������������Ϸ������߼���
		GameControl gameControl= new GameControl(jPanelGame, service);
		//������ҿ�������������Ϸ��������
		PlayControl pcontrol=new PlayControl(gameControl);
		//��װ��ҿ���
		jPanelGame.setGameControl(pcontrol);		
		new JFrameGame(jPanelGame);			
	}
	
}
