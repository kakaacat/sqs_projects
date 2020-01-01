package game.snake.first_try;

import javax.swing.JFrame;

public class Snake {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setBounds(550, 200, 950, 750);	//边界
		frame.setTitle("贪吃蛇1.0");		//标题
		frame.setResizable(false);		//能否改变大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//退出方式
		
		
		//SnakePanel panel = new SnakePanel();
		//frame.add(new SnakePanel());
		frame.add(new DBSnakePanel());
		
		frame.setVisible(true);
	}

}
