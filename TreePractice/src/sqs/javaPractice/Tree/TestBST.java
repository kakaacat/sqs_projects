package sqs.javaPractice.Tree;

import java.util.ArrayList;

public class TestBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建二叉树
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		//遍历树
		System.out.print("Inorder(sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.println("\n The number of nodes: " + tree.getSize());
		
		//查找指定元素
		System.out.println("The Peter in the tree? " + tree.search("Peter"));
			
		System.out.println("A path from the root to Peter: ");
		ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
		//打印路径
		for (int i = 0; path != null && i < path.size(); i++) {
			System.out.print(path.get(i).element + " ");
		}
		
		//创建int树
		Integer[] numbers = {2,4,3,1,7,5,8,6};
		BST<Integer> intTree = new BST<Integer>(numbers);
		System.out.println("\nInorder: ");
		intTree.inorder();
	}

}
