package sqs.javaPractice.Tree;

public interface Tree<E> extends Iterable<E> {

	//如果元素在树里返回true
	public boolean search(E e);
	//插入一个元素,成功则返回true
	public boolean insert(E e);
	//删除特定元素,成功则返回true
	public boolean delete(E e);
	//中根遍历树
	public void inorder();
	//后根遍历
	public void postorder();
	//先根遍历
	public void preorder();
	//树的结点数
	public int getSize();
	//判断树空否
	public boolean isEmpty();	
}
