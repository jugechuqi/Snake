package Show;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.source.tree.WhileLoopTree;

public class Menu extends JPanel{
	Menu(){
		this.setBounds(0, 0, 1280, 640);
		this.setLayout(null);
		//标题
		JLabel label=new JLabel();
		label=new JLabel();
		label.setBounds(500, 0, 500, 100);
		Font font = new Font("宋体", Font.PLAIN, 25);
		label.setFont(font);
		label.setText("请按数字选择游戏模式：");
		this.add(label);
		
		//模式一
		JLabel label1=new JLabel();
		label1=new JLabel();
		label1.setBounds(500, 100, 500, 100);
		label1.setFont(font);
		label1.setText("1、普通模式");
		this.add(label1);
		
		//模式二
		JLabel label2=new JLabel();
		label2=new JLabel();
		label2.setBounds(500, 200, 500, 100);
		label2.setFont(font);
		label2.setText("2、穿墙模式：");
		this.add(label2);
	}
}
