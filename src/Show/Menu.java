package Show;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.source.tree.WhileLoopTree;

public class Menu extends JPanel{
	Menu(){
		this.setBounds(0, 0, 1280, 640);
		this.setLayout(null);
		//����
		JLabel label=new JLabel();
		label=new JLabel();
		label.setBounds(500, 0, 500, 100);
		Font font = new Font("����", Font.PLAIN, 25);
		label.setFont(font);
		label.setText("�밴����ѡ����Ϸģʽ��");
		this.add(label);
		
		//ģʽһ
		JLabel label1=new JLabel();
		label1=new JLabel();
		label1.setBounds(500, 100, 500, 100);
		label1.setFont(font);
		label1.setText("1����ͨģʽ");
		this.add(label1);
		
		//ģʽ��
		JLabel label2=new JLabel();
		label2=new JLabel();
		label2.setBounds(500, 200, 500, 100);
		label2.setFont(font);
		label2.setText("2����ǽģʽ��");
		this.add(label2);
	}
}
