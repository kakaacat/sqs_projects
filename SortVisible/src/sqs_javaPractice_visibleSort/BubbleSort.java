package sqs_javaPractice_visibleSort;
/**
 * Ωªªª¿‡≈≈–Ú---√∞≈›≈≈–Ú(exchange sort---BubbleSort)
 * */
public class BubbleSort extends VisibleSort implements Sort,Runnable {
	Thread thread;
	
	BubbleSort(){
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
		for (int i = 0; i <= 98; i++) {
			for (int j = 0; j <= 98-i; j++) {
				if (array.get(j) > array.get(j+1)) {
					//µ˜ªªŒª÷√(change location)
					int temp = array.get(j);
					array.set(array.get(j+1), j); 
					array.set(temp, j+1);  
					//÷ÿª≠--redraw
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					repaint();
				}
			}
		}
		//–¸Õ£2s∫Û“˛≤ÿ hide this frame after 2s
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		super.jFrame.setVisible(false);
	}

}
