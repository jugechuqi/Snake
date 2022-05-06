package Show;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Game;
import Logic.Snake;

public class ShowScreen extends JFrame{
	private GameCanva canvas;
	private Game game;
	
	private Menu panel;
	
	private End end;
	
	public void init(Game game) {
		setTitle("yange����̰������ϷDEMO");
		this.setLayout(null);
		//���ô��ڳ�ʼ��С��λ��
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(1280, 640);
		setLocation(screenSize.width/8, screenSize.height/8);
		setVisible(true);
		
		this.game=game;

		//�������
		panel=new Menu();
		this.add(panel);
		
		//������Ϸ����
		canvas=new GameCanva(this,game);
		this.add(canvas);
		
		//������������
		end = new End();
		this.add(end);
	}
	
	public void start() {
		while(true) {
			//????????????????????????????????????
			//��֪��Ϊʲôֻ�м��������������������
			//System.out.println();
			//���ܺ��߳�֮����й�ϵ��
			//��֮���Կ϶����ǣ����������������ʲô��������Ч��
			//��ȫ�޷����
			//������������������������������������������
			//System.out.println(game.getState());
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			//���ϻ������˺���һ�������Ⱑ
			//������ȷʵ�Ǻ��߳��й�ϵ��ֻ����΢ֹͣһ˲�䣬����Ч
			//��������û�����������Ϊʲô
			//��������Դ����֮������⣿��Ϊִ��̫�죬������û��ʱ����������
			//֮�󲹲��߳�֪ʶ��
			//����������������������������������������������
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(game.getState().equals(Game.states[0])) {
				panel.setVisible(true);
				canvas.setVisible(false);
				end.setVisible(false);
			}
			else if(game.getState().equals(Game.states[1])||game.getState().equals(Game.states[2])) {
				panel.setVisible(false);
				end.setVisible(false);
				canvas.setVisible(true);
				canvas.start();
			}else {
				end.setVisible(true);
				panel.setVisible(false);
				canvas.setVisible(false);
			}
		}
		
	}

	public GameCanva getCanvas() {
		return canvas;
	}

	public void setCanvas(GameCanva canvas) {
		this.canvas = canvas;
	}
	
}
