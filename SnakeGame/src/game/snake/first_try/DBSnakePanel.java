package game.snake.first_try;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DBSnakePanel extends JPanel implements KeyListener,Runnable {
	//加载图片
	ImageIcon up = new ImageIcon("up.png");
	ImageIcon down = new ImageIcon("down.png");
	ImageIcon right = new ImageIcon("right.png");
	ImageIcon left = new ImageIcon("left.png");
	ImageIcon body = new ImageIcon("body.png");
	ImageIcon food = new ImageIcon("food.png");
	ImageIcon title = new ImageIcon("title.png");
	
	//数组来存放蛇身体节点的坐标
	int[] snakex = new int[850];
	int[] snakey = new int[850];
	
	int len = 3;  //初始长度
	int score = 0;//初始分数
	String direction = "R"; //初始方向
	int n = 150;
	
	
	Random random = new Random();
	//随机生成食物
	int foodx = random.nextInt(36) * 25 + 25; //25-925
	int foody = random.nextInt(24) * 25 + 75; //75-675
	
	boolean foodFitFlag = true;
	boolean isStarted = false;
	boolean isFaild = false;
	
	public Image iBuffer;
	public Graphics gBUffer;
	
	public DBSnakePanel() {
		this.setFocusable(true); 
		initSnake();
		this.addKeyListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	
	//初始化
	public void initSnake() {
		isFaild = false;
		isStarted = false;
		len = 3;
		score = 0;
		n = 150;
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
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(n);
			} catch (Exception e) {}
			
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
				//if(score % 3 == 0) n = n - 10;  
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
	/** 画板*/
	public void paint(Graphics g) {
		if(iBuffer == null) {
			iBuffer = createImage(this.getSize().width, this.getSize().height);
			gBUffer = iBuffer.getGraphics();
		}
		//画背景
		gBUffer.setColor(Color.BLACK);
		gBUffer.fillRect(25, 75, 900, 625);
		//画标头
		title.paintIcon(this, gBUffer, 25, 10);
		//画蛇头
		if(direction.equals("R")) {
			right.paintIcon(this, gBUffer, snakex[0], snakey[0]);	
		}else if(direction.equals("L")) {
			left.paintIcon(this, gBUffer, snakex[0], snakey[0]);	
		}else if(direction.equals("U")) {
			up.paintIcon(this, gBUffer, snakex[0], snakey[0]);	
		}else if(direction.equals("D")) {
			down.paintIcon(this, gBUffer, snakex[0], snakey[0]);	
		}
		//画蛇身
		for(int i=1; i<len; i++) {
			body.paintIcon(this, gBUffer, snakex[i], snakey[i]);
		}
		//开始游戏提示字幕
		if(!isStarted) {
			gBUffer.setColor(Color.WHITE);
			gBUffer.setFont(new Font("arial",Font.BOLD,30));
			gBUffer.drawString("Press Space to Start or Pause", 230, 350);
		}
		//游戏结束提示
		if(isFaild) {
			gBUffer.setColor(Color.WHITE);
			gBUffer.setFont(new Font("arial",Font.BOLD,30));
			gBUffer.drawString("Game Over,Press Space to Start", 230, 350);
		}
		//画食物
		foodFitFlag = true;
		while(foodFitFlag) {
			if (isFoodFit()) {
				//食物位置合适
				food.paintIcon(this, gBUffer, foodx, foody);
				foodFitFlag = false;
			}else {
				//不合适重新生成
				foodx = random.nextInt(36) * 25 + 25;
				foody = random.nextInt(24) * 25 + 75;
			}
		}
		
		//分数显示
		gBUffer.setColor(Color.WHITE);
		gBUffer.setFont(new Font("arial",Font.PLAIN,15));
		gBUffer.drawString("Score: " + score, 800, 35);
		gBUffer.drawString("Length: " + len, 800, 55);
		
		//将图像一次性的绘制到屏幕上
		g.drawImage(iBuffer, 0, 0, this);
	}
	//还需要重写update才能真正消除闪烁
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	/** 键盘事件*/
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
}
