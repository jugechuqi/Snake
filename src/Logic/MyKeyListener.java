package Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{
	Game game;
	Snake snake;
	public MyKeyListener(Game game){
		init(game);
	}
	public void init(Game game) {
		this.game=game;
		snake=game.getSnake();
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		game.setSpeed(1);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char getKey=e.getKeyChar();
		if(game.getState().equals(Game.states[0])) {
			if(getKey=='1') {
				game.setState(Game.states[1]);
			}else if(getKey=='2') {
				game.setState(Game.states[2]);
			}
		}else if(!game.getState().equals(Game.states[Game.states.length-1])) {
			if(getKey=='w') {
				if(snake.getOrientation()[0]!=1||snake.getOrientation()[1]!=0) {
					if(snake.getOrientation()[0]==-1&&snake.getOrientation()[1]==0) {
						game.setSpeed(2);
					}else {
						snake.setOrientation(snake.dir[3]);
						game.setSpeed(1);
					}
				}
			}else if(getKey=='s') {
				System.out.println("s");
				if(snake.getOrientation()[0]!=-1||snake.getOrientation()[1]!=0) {
					if(snake.getOrientation()[0]==1&&snake.getOrientation()[1]==0) {
						game.setSpeed(2);
					}else {
						snake.setOrientation(snake.dir[1]);
						game.setSpeed(1);
					}
				}
			}else if(getKey=='a') {
				if(snake.getOrientation()[0]!=0||snake.getOrientation()[1]!=1) {
					if(snake.getOrientation()[0]==0&&snake.getOrientation()[1]==-1) {
						game.setSpeed(2);
					}else {
						snake.setOrientation(snake.dir[2]);
						game.setSpeed(1);
					}
				}
			}else if(getKey=='d') {
				System.out.println("d");
				if(snake.getOrientation()[0]!=0||snake.getOrientation()[1]!=-1) {
					if(snake.getOrientation()[0]==0&&snake.getOrientation()[1]==1) {
						game.setSpeed(2);
					}else {
						snake.setOrientation(snake.dir[0]);
						game.setSpeed(1);
					}
				}
			}
		}else {
			if(getKey=='r') {
				game.setState(Game.states[0]);
				game.init();
				this.init(game);
			}
		}
		
	}

}
