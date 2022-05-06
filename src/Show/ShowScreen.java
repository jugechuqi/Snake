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
		setTitle("yange自制贪吃蛇游戏DEMO");
		this.setLayout(null);
		//设置窗口初始大小与位置
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(1280, 640);
		setLocation(screenSize.width/8, screenSize.height/8);
		setVisible(true);
		
		this.game=game;

		//设置面板
		panel=new Menu();
		this.add(panel);
		
		//设置游戏窗口
		canvas=new GameCanva(this,game);
		this.add(canvas);
		
		//设置死亡画面
		end = new End();
		this.add(end);
	}
	
	public void start() {
		while(true) {
			//????????????????????????????????????
			//不知道为什么只有加了输出语句才能正常运行
			//System.out.println();
			//可能和线程之类的有关系？
			//总之可以肯定的是，不管输出的内容是什么，都是有效的
			//完全无法理解
			//？？？？？？？？？？？？？？？？？？？？？
			//System.out.println(game.getState());
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			//网上还真有人和我一样的问题啊
			//看起来确实是和线程有关系，只有稍微停止一瞬间，就有效
			//不过还是没搞清楚到底是为什么
			//可能是资源挤兑之类的问题？因为执行太快，监听者没有时机被运作？
			//之后补补线程知识吧
			//！！！！！！！！！！！！！！！！！！！！！！！
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
