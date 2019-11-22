package sqs_javaPractice_visibleSort;
/**
 * 用来排序的数组
 * the arrary ready to sort
 * */
public class ArrayNeedToSort {
	int[] array;
	
	ArrayNeedToSort() {
		array = new int[100];
	}
	
	//初始化数组
	public void initalArray() {
		for (int i = 0; i < 100; i++) {
			array[i] = i + 1;
		}
	}
	//伪随机打乱数组
	public void messArray() {
		for (int i = 0; i < 100; i++) {
			int temp = array[i];
			int j = (int)(Math.random()*100);
			if (i != j) {
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}	
	//获得指定下标的数组元素
	public int get(int i) {
		if (i > 100 || i < 0) {
			System.err.println("下标错误！");
		}else {
			return array[i];
		}		
		return 0;
	}
	//设置指定下标的数组元素
	//即：temp替换  array[i]的值
	public void set(int temp,int i) {
		if (i > 100 || i < 0) {
			System.err.println("下标错误！");
		}else {
			array[i] = temp; //修改下标为i的数组的值
		}		
	}	
}
