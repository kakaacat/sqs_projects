package sqs_javaPractice_visibleSort;
/**
 * 主函数
 * the entrance of this program
 * 内部排序
 * ->插入类排序
 * -->直接插入排序(insert sort)
 * -->折半插入排序(binary sort)
 * -->希尔排序(shell sort)
 * ->交换类排序
 * -->冒泡排序(bubble sort)
 * -->快速排序(quick sort)
 * ->选择类排序
 * -->简单选择排序
 * -->树形选择排序
 * -->堆排序
 * ->归并排序
 * ->分配类排序
 * -->多关键字排序
 * -->链式基数排序
 * */
public class MainTest {
	public static void main(String[] args) {
		//直接插入排序(insert sort)
		InsertSort insertSort = new InsertSort();
		insertSort.startSort();
		//冒泡排序(bubble sort)
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.startSort();
		//希尔排序(shell sort)
		ShellSort shellSort = new ShellSort();
		shellSort.startSort();
		//快速排序(quick sort)
		QuickSort quickSort = new QuickSort();
		quickSort.startSort();
		
		//折半插入排序(binary sort)
		BinarySort binarySort = new BinarySort();
		binarySort.startSort();
	}
}
