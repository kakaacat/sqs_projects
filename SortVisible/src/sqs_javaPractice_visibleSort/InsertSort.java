package sqs_javaPractice_visibleSort;

/**
 * 插入排序----直接插入排序
 * */
public class InsertSort extends VisibleSort implements Sort,Runnable{	
	
	Thread thread ;
	
	InsertSort(){
		thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				startSort();
			} catch (Exception e) {
				System.err.println("错误！");
			}			
		}	
	}
	
	//直接插入排序可视化
	@Override
	public void startSort() {
		for (int i = 1; i < 100; i++) {
			int temp = super.array.get(i); //把要插入排序的数先暂存到临时变量中
			int j = i - 1; //用于标记插入位置
			while(temp < array.get(j)) {//寻找插入位置
				array.set(array.get(j), j+1);
				j -= 1;
				try {
					Thread.sleep(10); //每次重画都要有一定的延迟，为了看清！
				} catch (Exception e) {}
				super.repaint();				
			}
			array.set(temp, j+1);			
		}
	}
}
