package Show;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class End extends JPanel{
	End(){
		this.setBounds(0, 0, 1280, 640);
		this.setLayout(null);
		//����
		JLabel label=new JLabel();
		label=new JLabel();
		label.setBounds(500, 100, 500, 100);
		Font font = new Font("����", Font.BOLD, 30);
		label.setFont(font);
		label.setForeground(Color.red);
		label.setText("������������Ϸ����");
		this.add(label);
		
		//����
		JLabel label1=new JLabel();
		label1=new JLabel();
		label1.setBounds(500, 300, 500, 100);
		Font font1 = new Font("����", Font.PLAIN, 25);
		label1.setFont(font1);
		label1.setText("��R����ģʽѡ�����");
		this.add(label1);
	}
}
