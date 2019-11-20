package sqs.javaPractice.Tree;

import java.util.ArrayList;
import java.util.Iterator;

public class BST <E extends Comparable<E>> 
	extends AbstractTree<E>{

	protected TreeNode<E> root;
	protected int size = 0;
	
	//创建初始化的二叉树
	public BST() {}
	//创建object类型数组的二叉树
	public BST(E[] object) {
		for(int i = 0;i < object.length; i++)
			insert(object[i]);
	}
	
	@Override
	//查找树中的元素
	public boolean search(E e) {
		TreeNode<E> current = root;
		while(current != null) {
			if(e.compareTo(current.element) < 0) {
				current = current.left;
			}else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}else 
				return true; //所要找的元素即为当前结点的值
		}
		return false;
	}

	@Override
	//插入元素
	public boolean insert(E e) {
		if(root == null)
			root = createNewNode(e);
		//定位父亲结点
		else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}else 
					return false; //重复元素插入失败
			}
			//插入元素
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			}else {
				parent.right = createNewNode(e);
			}
		}
		
		size++;
		return true;
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}
	
	@Override
	//中序遍历
	public void inorder() {
		inorder(root);
	}
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	@Override
	//后序遍历
	public void postorder() {
		postorder(root);
	}
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	//先序遍历
	@Override
	public void preorder() {
		preorder(root);
	}
	protected void preorder(TreeNode<E> root) {
		if(root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//树结点类
	public static class TreeNode<E extends Comparable<E>>{
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;
		
		public TreeNode(E e){
			element = e;
		}
	}
	
	//返回根结点
	public TreeNode<E> getRoot(){
		return root;
	}
	
	//从根结点到制定元素的路径
	public ArrayList<TreeNode<E>> path(E e){
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root;
		
		while(current != null) {
			list.add(current); //添加结点
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}else break; 
		}
		
		return list;
	}
	
	
	//删除指定元素
	@Override
	public boolean delete(E e) {
		//首先找到指定元素
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		 
		while(current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}else break;
		}
		if (current == null) {
			return false;
		}
		//1.没有左孩子
		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			}else{
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
				}else parent.right = current.right;	
			}
		}else {	//2.没有右孩子
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			while(rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			//替换
			current.element = rightMost.element;
			
			if(parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else 
				parentOfRightMost.left = rightMost.left;
			
		}
		size--;
		return true;
	}

	@Override
	//结点数
	public int getSize() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new InorderIterator();
	}
	private class InorderIterator implements Iterator<E> {
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0; //元素个数
	
		public InorderIterator() {
			inorder();
		}
		
		
		private void inorder() {
			inorder(root);
		}
		private void inorder(TreeNode<E> root) {
			if(root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		@Override
		public boolean hasNext() {
			if(current < list.size())
				return true;
			return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}
		
		@Override
		public void remove() {
			delete(list.get(current));//删除当前元素
			list.clear();//清空列表
			inorder();//重建列表
		}
		
		//删除所有元素
		public void clear() {
			root = null;
			size = 0;
		}
		
	}

}
