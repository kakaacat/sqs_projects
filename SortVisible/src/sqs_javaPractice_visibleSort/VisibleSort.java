package sqs_javaPractice_visibleSort;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VisibleSort extends JPanel{
	JFrame jFrame;
	ArrayNeedToSort array;
	
	VisibleSort() {
		array = new ArrayNeedToSort();
		array.initalArray();
		array.messArray();
		windowFrom();
	}
	
	//排序可视化
	public void paint(Graphics g) {
		//每次画之前都要先清空画板
		g.clearRect(0, 0, 1500,800);
		

		
		for (int i = 0; i < 100; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(i*10+100,(500-(array.get(i)*4)),10, array.get(i)*4);
		}
		
	}
	
	
	
	//窗口设置
	public void windowFrom() {
		jFrame = new JFrame();
		
		jFrame.setSize(1200,580);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		
		
		jFrame.add(this);
		jFrame.setVisible(true);
	}
}
