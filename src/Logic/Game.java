package Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import Show.ShowScreen;

public class Game{
	public static String[] states= {"ready","normal_modle","through_wall_modle","end"};
	private String state;
	public int ROW,COL;
	private int score;
	private Snake snake;
	private int speed;//���˶����ٶȣ���start���µ��ٶȣ�������ʱ��ķ��ȣ�
	private int path=50;
	private boolean isEat;
	private boolean[][] isSnake;
	private int[] fruit;
	public int[] getFruit() {
		return fruit;
	}
	public void setFruit(int[] fruit) {
		this.fruit = fruit;
	}
	private MyKeyListener myKeyListener;
	
	private ShowScreen screen;

	public ShowScreen getScreen() {
		return screen;
	}
	public void setScreen(ShowScreen screen) {
		this.screen = screen;
		screen.addKeyListener(myKeyListener);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Game() {
		speed=1;
		state="ready";
		ROW=32;
		COL=64;
		snake=new Snake();
		score=0;
		whereIsSnake();
		fruit=creatFruit();
		isEat=false;
		myKeyListener=new MyKeyListener(this);
	}
	
	public void init() {
		speed=1;
		ROW=32;
		COL=64;
		snake=new Snake();
		score=0;
		whereIsSnake();
		fruit=creatFruit();
		isEat=false;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void start() {
		try {
			Thread.sleep(path/speed);
			
			if(isEat) {//����ˮ����Ҫ������һ��ˮ��
				fruit = creatFruit();
				isEat = false;
			}
			whereIsSnake();
			int[] orien=snake.getOrientation();
			int[] head=snake.getHead();
			int nextRow=head[0]+orien[0];
			int nextCol= head[1]+orien[1];
			if(state.equals("normal_modle")) {
				if(nextRow==0||nextRow==ROW||nextCol==0||nextCol==COL) {
					dead();
				}else if(isSnake[nextRow][nextCol]){
					//ͷ����һ���ƶ�λ���Ƿ�β���Ĳ�λʱ���ƶ�������Ȼ���غϣ�Ҳ����ײ���Լ�
					//��Ϊ�ߵ��ƶ�ʵ����ÿ�������ı��ֻ����β����β����ʧ��β����һ��Ԫ�ر�Ϊβ��
					//ͷ������һ��λ�ñ�Ϊ��ͷ������ͷ����Ϊ��ͷ������ĵ�һ���ڵ�
					//ײ���Լ��ж�Ϊ����
					List<int[]> body= snake.getBody();
					int[] tail=body.get(body.size()-1);
					if(nextRow!=tail[0]&&nextCol!=tail[1]) {
						dead();
					}
				}
				else if(nextRow==fruit[0]&&nextCol==fruit[1]) {
					isEat=true;
					snake.eat(nextRow, nextCol);
					score++;
				}
			}else if(state.equals("through_wall_modle")) {
				if(nextRow==0||nextRow==ROW||nextCol==0||nextCol==COL) {
					if(nextRow==0) {
						nextRow=ROW-1;
					}else if(nextRow==ROW) {
						nextRow=1;
					}else if(nextCol==0) {
						nextCol=COL-1;
					}else if(nextCol==COL) {
						nextCol=1;
					}
				}else if(isSnake[nextRow][nextCol]){
					//ͷ����һ���ƶ�λ���Ƿ�β���Ĳ�λʱ���ƶ�������Ȼ���غϣ�Ҳ����ײ���Լ�
					//��Ϊ�ߵ��ƶ�ʵ����ÿ�������ı��ֻ����β����β����ʧ��β����һ��Ԫ�ر�Ϊβ��
					//ͷ������һ��λ�ñ�Ϊ��ͷ������ͷ����Ϊ��ͷ������ĵ�һ���ڵ�
					//ײ���Լ��ж�Ϊ����
					List<int[]> body= snake.getBody();
					int[] tail=body.get(body.size()-1);
					if(nextRow!=tail[0]&&nextCol!=tail[1]) {
						dead();
					}
				}else if(nextRow==fruit[0]&&nextCol==fruit[1]) {
					isEat=true;
					snake.eat(nextRow, nextCol);
					score++;
				}
			}
			if(!isEat) snake.move(nextRow,nextCol);
			//speed=1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//��������λ�ñ�ǳ��������㴴��ˮ��ʱ���ᴴ����������
	public void whereIsSnake() {
		isSnake=new boolean[ROW+1][COL+1];
		int[] head=snake.getHead();
		isSnake[head[0]][head[1]]=true;
		List<int[]> body= snake.getBody();
		for(int i=0;i<body.size();i++) {
			int[] node=body.get(i);
			isSnake[node[0]][node[1]]=true;
		}
	}
	//����ˮ��,���ܴ�����ǽ�ϻ���������
	public int[] creatFruit() {
		int[] res=new int[2];
		Random random=new Random();
		int row,col;
		do{
			row=random.nextInt(ROW)+1;
			col=random.nextInt(COL)+1;
		}while(isSnake[row][col]||row==0||row==ROW||col==0||col==COL);
		res[0]=row;
		res[1]=col;
		return res;
	}
	
	public void dead() {
		state="end";
		screen.getCanvas().clear();
	}
}