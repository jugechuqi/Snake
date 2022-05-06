package Show;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JLabel;

import Logic.Game;
import Logic.Snake;


public class GameCanva extends Canvas{
	Game game;
	Snake snake;
	List<int[]> body;

	private JLabel lable;
	private String scoreText="得分：";
	
	//双缓冲
	private Image iBuffer;
	private Graphics gBuffer;
	
	public GameCanva(ShowScreen screen,Game game){
		//this.setLayout(null);
		this.setBounds(0, 0, 1000, 640);
		this.game=game;
		snake=game.getSnake();
		body=snake.getBody();
		//设置得分面板
		lable=new JLabel();
		lable.setBounds(1000, 100, 100, 100);
		Font font = new Font("宋体", Font.BOLD, 25);
		lable.setForeground(Color.blue);
		lable.setFont(font);
		lable.setText(scoreText+"0");
		screen.add(lable);
	}
	
	public void init() {
		snake=game.getSnake();
		body=snake.getBody();
	}
	
	public void start() {
		init();
		while(!game.getState().equals(Game.states[Game.states.length-1])) {
			game.start();
			lable.setText(scoreText+game.getScore());
			paint(getGraphics());
			
		}
	}
	
	public void clear() {
		super.repaint();
	}
	
	public void update(Graphics g){ 
		if(iBuffer==null) {
			iBuffer=createImage(this.getSize().width,this.getSize().height);
			gBuffer=iBuffer.getGraphics();
		}
		Color c=gBuffer.getColor();
		gBuffer.setColor(Color.white);
		gBuffer.fillRect(0,0, this.getSize().width,this.getSize().height);
		gBuffer.setColor(c);
		
		paint(gBuffer);
		g.drawImage(iBuffer, 0,0,this);
	}
	public void paint(Graphics g) {
		//绘制墙体
		g.setColor(Color.ORANGE);
		for(int i=0;i<=game.COL;i++) {
			g.fillRect(i*15,0,15,15);
			g.fillRect(i*15,game.ROW*15,15,15);
		}
		for(int i=0;i<=game.ROW;i++) {
			g.fillRect(0,i*15,15,15);
			g.fillRect(game.COL*15,i*15,15,15);
		}
		//绘制蛇：
		//1.绘制蛇头
		g.setColor(Color.blue);
		g.fillRect(snake.getHead()[1]*15, snake.getHead()[0]*15,15,15);
		//2.绘制蛇身
		g.setColor(Color.green);
		
		for(int i=0;i<body.size();i++) {
			int[] node=body.get(i);
			g.fillRect(node[1]*15, node[0]*15,15,15);
		}
		
		//3.绘制水果
		g.setColor(Color.red);
		g.fillRect(game.getFruit()[1]*15, game.getFruit()[0]*15,15,15);
		
		
		super.repaint();
	}
}
