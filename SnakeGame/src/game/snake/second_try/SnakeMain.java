package game.snake.second_try;

import javax.swing.JFrame;

public class SnakeMain {

	public static void main(String[] args) {
		//生成一个窗口
		JFrame frame = new JFrame();
		frame.setBounds(500, 200, 950, 750); //窗口的位置大小
		frame.setTitle("贪吃蛇1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
		frame.setResizable(false);
		
		//游戏界面
		SnakeGamePanel snakeGamePanel = new SnakeGamePanel();
		frame.add(snakeGamePanel);
		
		frame.setVisible(true);
	}

}
