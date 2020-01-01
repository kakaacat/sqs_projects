package game.snake.second_try;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGamePanel extends JPanel implements KeyListener, ActionListener{
	//加载图片
	ImageIcon up = new ImageIcon("up.png");
	ImageIcon down = new ImageIcon("down.png");
	ImageIcon right = new ImageIcon("right.png");
	ImageIcon left = new ImageIcon("left.png");
	ImageIcon body = new ImageIcon("body.png");
	ImageIcon food = new ImageIcon("food.png");
	ImageIcon title = new ImageIcon("title.png");

	int[] snakex = new int[850];
	int[] snakey = new int[850];
	
	int len = 3;
	int score = 0;
	String direction = "R";
	
	Random random = new Random();
	//随机生成食物
	int foodx = random.nextInt(36) * 25 + 25; //25-925
	int foody = random.nextInt(24) * 25 + 75; //75-675
	
	boolean flag = true;
	boolean isStarted = false;
	boolean isFaild = false;
	
	Timer timer = new Timer(150,this);
	
	public SnakeGamePanel() {
		this.setFocusable(true);
		initSnake();
		this.addKeyListener(this);
		timer.start();
	}
	
	//初始化
	public void initSnake() {
		isFaild = false;
		isStarted = false;
		len = 3;
		score = 0;
		direction = "R";
		snakex[0] = 100; 
		snakey[0] = 100; 
		snakex[1] = 75; 
		snakey[1] = 100; 
		snakex[2] = 50; 
		snakey[2] = 100;	
	}
	
	//判断食物生成位置是否在蛇身
	public boolean isFoodFit() {
		for (int i = 0; i < len; i++) {
			if(foodx == snakex[i] && foody == snakey[i]) {
				return false; //食物生成在蛇身
			}
		}
		return true;
	}
	
	/**
	 * 画板*/
	public void paint(Graphics g) {
		//画背景
		this.setBackground(Color.BLACK);
		g.fillRect(25, 75, 900, 625);
		//画标头
		title.paintIcon(this, g, 25, 10);
		//画蛇头
		if(direction.equals("R")) {
			right.paintIcon(this, g, snakex[0], snakey[0]);	
		}else if(direction.equals("L")) {
			left.paintIcon(this, g, snakex[0], snakey[0]);	
		}else if(direction.equals("U")) {
			up.paintIcon(this, g, snakex[0], snakey[0]);	
		}else if(direction.equals("D")) {
			down.paintIcon(this, g, snakex[0], snakey[0]);	
		}
		//画蛇身
		for(int i=1; i<len; i++) {
			body.paintIcon(this, g, snakex[i], snakey[i]);
		}
		//开始游戏提示字幕
		if(!isStarted) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("请按空格键开始或暂停", 300, 350);
		}
		//游戏结束提示
		if(isFaild) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("游戏结束！按空格重新开始", 300, 350);
		}
		//画食物
		flag = true;
		while(flag) {
			if (isFoodFit()) {
				//食物位置合适
				food.paintIcon(this, g, foodx, foody);
				flag = false;
			}else {
				//不合适重新生成
				foodx = random.nextInt(36) * 25 + 25;
				foody = random.nextInt(24) * 25 + 75;
			}
		}
		
		//分数显示
		g.setColor(Color.WHITE);
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("Score: " + score, 800, 35);
		g.drawString("Length: " + len, 800, 55);
	}

	/**
	 * 键盘事件*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		//开始暂停控制
		int keyCode = arg0.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) {
			if(isFaild) {
				initSnake();
			}else{
				isStarted = !isStarted;
			}
		//设移动控制
		}else if(keyCode == KeyEvent.VK_UP && !direction.equals("D")) {
			direction = "U";
		}else if(keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {
			direction = "D";
		}else if(keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
			direction = "L";
		}else if(keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {
			direction = "R";
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(isStarted && !isFaild) {
			//蛇身移动----每个结点等于其前面结点的坐标
			for(int i=len; i>.0; i--) {
				snakex[i] = snakex[i-1];
				snakey[i] = snakey[i-1];
			}
			//蛇头移动
			if(direction.equals("R")) {
				snakex[0] = snakex[0] + 25;
				if(snakex[0] > 900) snakex[0] = 25;
			}else if(direction.equals("L")) {
				snakex[0] = snakex[0] - 25;	
				if(snakex[0] < 25) snakex[0] = 900;
			}else if(direction.equals("U")) {
				snakey[0] = snakey[0] - 25;
				if(snakey[0] < 75) snakey[0] = 675;
			}else if(direction.equals("D")) {
				snakey[0] = snakey[0] + 25;	
				if(snakey[0] > 675) snakey[0] = 75;
			}
			if(snakex[0] == foodx && snakey[0] == foody) {
				len++;
				score++;
				foodx = random.nextInt(36) * 25 + 25;
				foody = random.nextInt(22) * 25 + 75;
			}
			//失败判定
			for(int i = 1; i < len; i++) {
				if(snakex[0] == snakex[i] && snakey[0] == snakey[i]) {
					isFaild = true;
				}
			}
		}
		repaint();
	}

}
