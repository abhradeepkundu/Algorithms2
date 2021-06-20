
public class TreeTraversals {

	public TreeTraversals() {
		// TODO Auto-generated constructor stub
		this.run();
		
	}
	private int top = -1;
	public static final int STACKSIZE = 50;
	public static class Node{
		int value;
		Node left;
		Node right;
		Node(int val) {
			this.value = val;
		}
	}
	
	public boolean stackEmpty(Node[] s) {	
		if(top < 0 )
			return true;
		
		return false;
	}
	public boolean stackFull(Node[] s) {	
		if(top >= STACKSIZE )
			return true;
		
		return false;
	}
	public void push(Node[] s,Node node) {
		if(stackFull(s))  {
			System.out.println("Stack is full !!");
			return;
		}
		s[++top] = node;
	}
	public Node pop(Node[] s) {
		if(stackEmpty(s)) {
			System.out.println("Stack is Empty !!");
			return null;
		}
		Node node = s[top--];
		return node;
	}
	int height;
	
	/**
	 * Helper function to perform tree operations
	 * */
	public void run() {
		Node[] s = new Node[STACKSIZE];
		//System.out.println("stack size : " + s.length);
		Node root = new Node(25);		
		insertNode(root,32);
		insertNode(root,21);
		insertNode(root,22);
		insertNode(root,19);
		insertNode(root,35);
		inorder(root);
		System.out.println();
		//System.out.println("Non-Recursive Tree Traversal");		
		//NonRecurPreorder(root,s);
		height = height(root);
		bottomUpHelper(root);
		
	}
	/**
	 * function to insert  Node in the Tree
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val < node.value) {
			if(node.left == null)
				node.left = new Node(val);
			else
				insertNode(node.left, val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else
				insertNode(node.right, val);
		}
	}
	/**
	 * Function to calculate the height of the tree
	 * */
	public int height(Node node) {
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return 1 + max(lheight,rheight);
	}
	
	private int max(int lheight, int rheight) {
		// TODO Auto-generated method stub
		if(lheight > rheight)
			return lheight;
		else
			return rheight;
	}
	public void bottomUpHelper(Node node) {
		for(int i = height; i >= 0; --i)
			bottomUp(node,i);
	}
	/**
	 * Function to print Tree elements in Bottom up approach
	 * */
	public void bottomUp(Node node,int k) {
		if(node == null)
			return;
		if(k == 0)
			System.out.print(node.value + " ");
		else {
			bottomUp(node.left,k-1);
			bottomUp(node.right,k-1);
		}
	}
	
	/**
	 * iterative Preorder Tree traversal
	 * */
	public void NonRecurPreorder(Node node,Node[] s) {
		if(node == null)
			return;
		
		push(s,node);
		while(!stackEmpty(s)) {
			Node popNode = pop(s);
			if(popNode.right != null)
				push(s,popNode.right);
			if(popNode.left != null)
				push(s,popNode.left);
			System.out.print(popNode.value + " ");
		}
	}
	/**
	 * Recursive inorder Tree Traversal
	 * */
	public void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreeTraversals();
	}

}
