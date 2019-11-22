package sqs_javaPractice_visibleSort;
/**
 * 插入排序---希尔排序(insert sort---shell sort)
 * */
public class ShellSort extends VisibleSort implements Sort,Runnable{

	Thread thread;
	int[] delta = {4,2,1}; //增量
	
	ShellSort(){
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				startSort();
			} catch (Exception e) {}
		}
		
	}

	@Override
	public void startSort() {
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		
		for (int i = 0; i < 3; i++) {
			shellSort(delta[i]);
		}
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		super.jFrame.setVisible(false);
	}
	
	
	public void shellSort(int delta) {
		for (int i = delta; i < 100; i++) {
			if (array.get(i) < array.get(i-delta)) {
				int temp = array.get(i);
				//子序列内排序--subsequent sort
				int j;
				for (j = i-delta; j>=0 && temp < array.get(j); j-=delta) {
					array.set(array.get(j), j+delta);
					//重画--redraw
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					repaint();
				}
				array.set(temp, j+delta);	
			}
		}
	}

}
