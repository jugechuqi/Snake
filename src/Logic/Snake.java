package Logic;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	public int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};//右左上下
	private int[] orientation;//蛇运动朝向
	private int length;
	private int[] head;
	private List<int[]> body;
	public Snake() {
		init();
	}
	public void init() {
		//设置默认朝向
		orientation=new int[2];
		orientation=dir[0];//默认朝右
		//蛇移动时,可以看做,下一个蛇身跑到了上一个蛇身的位置
		//所以设置蛇头的位置，蛇的位置默认为蛇头的位置
		head=new int[2];
		head[0]=1;head[1]=4;
		length=3;
		body=new ArrayList<>();
		for(int i=1;i<length;i++) {//初始化蛇身
			int[] node=new int[2];
			node[0]=head[0];node[1]=head[1]-i;
			body.add(node);
		}
	}
	public void setOrientation(int[] orientation) {
		this.orientation = orientation;
	}
	public void move(int x,int y) {//蛇的移动：参数为蛇头的位置
		body.remove(body.size()-1);//删除尾部
		int[] sec=new int[2];
		sec[0]=head[0];sec[1]=head[1];
		body.add(0,sec);//将旧头部变为身体
		head[0]=x;
		head[1]=y;
	}
	public void eat(int x,int y) {//蛇吃到了东西（水果），身体变长：参数为水果（新蛇头）的位置
		//吃到水果的那一瞬间的变化，常规理解是，蛇头移动到了水果的位置，身体顺次移动
		//而末尾新加了一节身体
		//转换思路，反过来想，实际上也可以理解为，水果变为了蛇头，蛇头变为了身体，蛇身保持不变
		//这样问题就相对简化了
		int[] sec=new int[2];
		sec[0]=head[0];sec[1]=head[1];
		body.add(0, sec);
		head[0]=x;head[1]=y;
		
		length++;//身体变长
	}
	public int getLength() {
		return length;
	}
	public List<int[]> getBody() {
		return body;
	}
	public int[] getHead() {
		return head;
	}
	public int[] getOrientation() {
		return orientation;
	}
}
