package Logic;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	public int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};//��������
	private int[] orientation;//���˶�����
	private int length;
	private int[] head;
	private List<int[]> body;
	public Snake() {
		init();
	}
	public void init() {
		//����Ĭ�ϳ���
		orientation=new int[2];
		orientation=dir[0];//Ĭ�ϳ���
		//���ƶ�ʱ,���Կ���,��һ�������ܵ�����һ�������λ��
		//����������ͷ��λ�ã��ߵ�λ��Ĭ��Ϊ��ͷ��λ��
		head=new int[2];
		head[0]=1;head[1]=4;
		length=3;
		body=new ArrayList<>();
		for(int i=1;i<length;i++) {//��ʼ������
			int[] node=new int[2];
			node[0]=head[0];node[1]=head[1]-i;
			body.add(node);
		}
	}
	public void setOrientation(int[] orientation) {
		this.orientation = orientation;
	}
	public void move(int x,int y) {//�ߵ��ƶ�������Ϊ��ͷ��λ��
		body.remove(body.size()-1);//ɾ��β��
		int[] sec=new int[2];
		sec[0]=head[0];sec[1]=head[1];
		body.add(0,sec);//����ͷ����Ϊ����
		head[0]=x;
		head[1]=y;
	}
	public void eat(int x,int y) {//�߳Ե��˶�����ˮ����������䳤������Ϊˮ��������ͷ����λ��
		//�Ե�ˮ������һ˲��ı仯����������ǣ���ͷ�ƶ�����ˮ����λ�ã�����˳���ƶ�
		//��ĩβ�¼���һ������
		//ת��˼·���������룬ʵ����Ҳ�������Ϊ��ˮ����Ϊ����ͷ����ͷ��Ϊ�����壬�����ֲ���
		//�����������Լ���
		int[] sec=new int[2];
		sec[0]=head[0];sec[1]=head[1];
		body.add(0, sec);
		head[0]=x;head[1]=y;
		
		length++;//����䳤
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
