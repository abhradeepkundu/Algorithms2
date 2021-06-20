

public class RootToLeafpaths {

	public RootToLeafpaths() {
		// TODO Auto-generated constructor stub
		run();
	}
	public static class Node {
		Node left;
		Node right;
		int value;
		Node(int val) {
			this.value = val;
		}
	}
	public void run() {
		Node rootNode = new Node(10);
		insertNode(rootNode ,8);
		insertNode(rootNode ,5);
		insertNode(rootNode ,15);
		insertNode(rootNode ,13);
		inorder(rootNode);
		System.out.println();
		
		printPaths(rootNode);
		
	}
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		inorder(node.right);
	}
	
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val < node.value) {
			if(node.left == null)
				node.left = new Node(val);
			else 
				insertNode(node.left,val);			
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else 
				insertNode(node.right,val);
		}
	}
	public void printPath(int a[],int len) {
		for(int i=0; i<len; i++)
				System.out.print(a[i] + " -> ");
		System.out.println();
	}
	public void printPathsUtil(Node node,int a[],int len) {
		if(node == null)
			return;
		
		a[len++] = node.value;
		if(node.left == null && node.right == null) 
			printPath(a,len);
		
		else {
			printPathsUtil(node.left,a,len);
			printPathsUtil(node.right,a,len);
		}
	}
	/**
	 * function to print root to leaf paths
	 * */
	public void printPaths(Node node) {
		int[] a = new int[100];
		int pathLen = 0;
		printPathsUtil(node,a,pathLen);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new RootToLeafpaths();
	}

}
