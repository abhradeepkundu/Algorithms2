
public class TreeViews {
	
	TreeViews() {
		run();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TreeViews();
	}
	
	/*****
	 * left view of the tree
	 *  12
       /     \
     10       30
            /    \
          25      40
	 * 
	 * */
	int maxLevelSoFar = 0;
	public void leftView(Node node,int curlevel) {
		if(node == null)
			return;
		
		if(maxLevelSoFar < curlevel) {
			System.out.println(node.data);
			maxLevelSoFar = curlevel;
		}
		leftView(node.left, curlevel+1);
		leftView(node.right, curlevel+1);
	}
	
	/*****
	 * right view of the tree
	 * 
	 * */
	public void rightView(Node node,int curlevel) {
		if(node == null)
			return;
		
		if(maxLevelSoFar < curlevel) {
			System.out.println(node.data);
			maxLevelSoFar = curlevel;
		}
		rightView(node.right, curlevel+1);
		rightView(node.left, curlevel+1);
	}
	
	public static class Node{
		Node left;
		Node right;
		Node next;
		int data;
		String color = "white";
		
		Node(int val) {
			this.data = val;
		}
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.data) { 
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	
	public void run() {
//		Node root = new Node(50);
//		insertNode(root, 30);
//		insertNode(root, 70);
//		insertNode(root, 20);
//		insertNode(root, 40);
//		insertNode(root, 60);
//		insertNode(root, 80);
//		insertNode(root, 10);
//		insertNode(root, 25);
//		insertNode(root, 35);
//		insertNode(root, 45);
//		insertNode(root, 75);
//		insertNode(root, 85);
//		insertNode(root, 65);
		
		Node root = new Node(20);
		insertNode(root, 8);
		insertNode(root, 4);
		insertNode(root, 22);
		insertNode(root, 12);
		insertNode(root, 10);
		insertNode(root, 14);
		insertNode(root, 25);
		
		

		//leftView(root,1);
		//rightView(root,1);
		System.out.println("inorder : ");
		inorder(root);
		System.out.println();
		System.out.println("Tree Boundry");
		//printTreeBoundry(root);
		printTreeBoundry2(root);
	}
	
	private void printTreeBoundry2(Node node) {
		System.out.print(node.data + " ");
		printLeft(node.left);
		printLeafNodes(node.left);
		printLeafNodes(node.right);
		printRight(node.right);
	}

	private void printLeft(Node node) {
		if(node == null)
			return;
		if(node.left != null || node.right != null)
			System.out.print(node.data + " ");
		printLeft(node.left);
	}
	
	private void printRight(Node node) {
		if(node == null)
			return;
		printRight(node.right);
		if(node.left != null || node.right != null)
			System.out.print(node.data + " ");
		
	}

	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.data+ " ");
		inorder(node.right);
	}
	
	/*
	   	      50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 
	  /  \   /\	  \	  /\ 	
	 10	 25 35 45 65 75 85
	 * */
	
	public void printTreeBoundry(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		printLeftBoundry(node.left);
		printLeafNodes(node.left);
		printLeafNodes(node.right);
		printRightBoundry(node.right);
	}

	private void printRightBoundry(Node node) {
		if(node == null)
			return;
		if(node.right !=null) {
			printRightBoundry(node.right);
			System.out.print(node.data + " ");
		}else if(node.left != null) {
			printRightBoundry(node.left);
			System.out.println(node.data + " ");
		}
	}

	private void printLeafNodes(Node node) {
		if(node == null)
			return;
		printLeafNodes(node.left);
		if(node.left == null && node.right == null)
			System.out.print(node.data + " ");
		printLeafNodes(node.right);
	}

	private void printLeftBoundry(Node node) {
		if(node == null)
			return;
		if(node.left !=null) {
			System.out.print(node.data + " ");
			printLeftBoundry(node.left);
		}else if(node.right != null) {
			System.out.print(node.data + " ");
			printLeftBoundry(node.right);
		}		
	}

}
