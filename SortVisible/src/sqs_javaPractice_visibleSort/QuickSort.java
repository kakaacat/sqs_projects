package sqs_javaPractice_visibleSort;

public class QuickSort extends VisibleSort implements Sort,Runnable{

	Thread thread;
	
	QuickSort(){
		thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		try {
			startSort();
		} catch (Exception e) {}
	}

	@Override
	public void startSort() {
		int low = 0;
		int high = 99;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		QuickSort(low,high);	
		//2s后隐藏
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		super.jFrame.setVisible(false);
	}
	public void QuickSort(int low ,int high) {
		if (low < high) {
			int pos = QKSort(low, high);
			QuickSort(low,pos-1);  //对左部子表排序
			QuickSort(pos+1,high); //对右部子表排序
		}
		
	}
	public int QKSort(int low,int high) {
		int temp = array.get(low); //基准记录
		while(low < high) {
			while(low < high && array.get(high) >= temp) {
				high--; //high从右向左找小于temp的数
			}
			if (low < high) { array.set(array.get(high), low); low++;}//找到放入左边“空位置”，此时右边有空位置
			while(low < high && array.get(low) <= temp) {
				low++; //low从左向右找大于temp的数
			}
			if(low < high) {array.set(array.get(low), high);high--;}//找到放入右边
			//重画--redraw
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
			repaint();
		}
		array.set(temp, low);//最后中间 low==high为空位置		
		return low;	//返回基准记录的位置
	}

}
