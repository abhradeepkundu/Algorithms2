
public class kthSmallestEleOfBST {

	public kthSmallestEleOfBST() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	
	/**
	 *  Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		int value;
		int lcount =1;
		int rcount =1;
		
		public Node(int val) {
			this.value = val;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(20);
		insertNode(rootNode,8);
		insertNode(rootNode,22);
		insertNode(rootNode,4);
		insertNode(rootNode,12);
		insertNode(rootNode,10);
		insertNode(rootNode,14);
		//System.out.println("left count " + rootNode.left.value + " -> " + rootNode.left.lcount);
		inorder(rootNode);
		System.out.println();
		//rightCount(rootNode);
		//printKthSmallestElement(rootNode);
		//printKthLargestElement(rootNode,2);
		int k = 5;
		System.out.println(kthLargestOfBST(rootNode,k));
		
		//System.out.println(rootNode.left.right.value + " -> " + rootNode.left.rcount);
		
	}
	
	/***
	 * kth largest element of BST
	 * */
		
	public int kthLargestOfBST(Node node,int k) {
		if(node == null)
			return -1;
		
		if(node.right != null) {
			k = kthLargestOfBST(node.right, k);
		}
		if(k == 1) {
			System.out.println("kth largest element is " + node.value  );
			return node.value;
		}
		
		k--;
		
		if(node.left != null) {
			k = kthLargestOfBST(node.left, k);
		}
		return k;
	}
	
	
	
	/***
	 * kth smallest element of BST
	 * */
		
	public int kthSmallestOfBST(Node node,int k) {
		if(node == null)
			return -1;
		
		if(node.left != null) {
			k = kthSmallestOfBST(node.left, k);
		}
		
		
		if(k == 1) {
			System.out.println("kth smallest element is " + node.value  );
			return node.value;
		}
		
		k--;
		
		if(node.right != null) {
			k = kthSmallestOfBST(node.right, k);
		}
		return k;
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		node.lcount++;	
		if(val <= node.value) {
			
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			node.rcount++;
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	public void printKthSmallestElement(Node node,int k) {
		
		Node newNode = kthSmallestElement(node,k);
		if(newNode != null)
			System.out.println("The " + k + " smallest element is "+ newNode.value);
		else
			System.out.println("The " + k + " smallest element is " + null);
	}	
	/**
	 * function to find the ith smallest element
	 * */
	public Node kthSmallestElement(Node node,int i) {
		if(i <= 0 ) {
			System.out.println("there is no such node present in the tree");
			//return;
		}
		int r;
		if(node.left == null)
			r = 1;
		else
			r = node.left.lcount + 1;
		
		System.out.println("i : " + i);
		System.out.println("r : " + r);
		System.out.println();
		//System.out.println("Travesring node : " + node.value + " r = " + r);
		if(i == r)
			return node;
		else if(i < r)
			return kthSmallestElement(node.left, i);
		else
			return kthSmallestElement(node.right, i - r);
	}
	public void printKthLargestElement(Node node,int k) {
		//int k = 1;
		Node newNode = KthLargestElement(node,k);
		System.out.println();
		if(newNode != null)
			System.out.println("The " + k + " Largest element is "+ newNode.value);
		else
			System.out.println("The " + k + " Largest element is " + null);
	}
	public Node KthLargestElement(Node node,int i) {
		int r;
		if( i <= 0 ) {
			System.out.println("InvAliD input");
			return null;
		}
		/*if(node == null)
			return null;*/
		System.out.println("calling node " + node.value);
		if(node.right != null) {
			r = node.right.lcount + 1;
			//System.out.println();
			//System.out.println("i : " + i);
			//System.out.println("r : " + r);
			
		}
		else 
			r = 1;
		if(i == r)
			return node;
		else if(i < r)
			return KthLargestElement(node.right,r-i);
		else 
			return KthLargestElement(node.left,i);		
	}
	

	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		//System.out.println();
		//System.out.print(node.rcount+ " ");
		inorder(node.right);
	}
	
	/**
	 * Right count of each Node
	 * 
	 * */
	public void rightCount(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.rcount+ " ");
		inorder(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("shams");
		new kthSmallestEleOfBST();
	}

}
