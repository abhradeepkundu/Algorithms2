
public class kthorderStatic {

	public kthorderStatic() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public static class Node{
		Node left;
		Node right;
		int lcount = 0;
		int value;
		
		Node(int val) {
			this.value = val; 
		}		
	}
	public void run() {
		Node rootNode = new Node(25);
		insertNode(rootNode,15);
		insertNode(rootNode,35);
		insertNode(rootNode,45);
		insertNode(rootNode,7);
		insertNode(rootNode,3);
		insertNode(rootNode,1);
		System.out.println("Inorder Traversal");
		inorder(rootNode);
		System.out.println();
		//System.out.println("L Count ");
		//printLCount(rootNode);
		System.out.println();
		//printKthSmallestElement(rootNode,8);
	}
	
	
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		//System.out.print(node.value+ " ");
		System.out.println( node.value + " :" + node.lcount);
		inorder(node.right);
	}
	/**
	 * Function to pint Left count of the node
	 * 
	 * */
	public void printLCount(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.lcount + 1 + " ");
		inorder(node.right);
	}
	public void insertNode(Node node,int k) {
		if(node == null)
			return;
		node.lcount++;
		
		if(k < node.value) {
			if(node.left == null)
				node.left = new Node(k);
			else 
				insertNode(node.left,k);
		}else {
			if(node.right == null)
				node.right = new Node(k);
			else 
				insertNode(node.right,k);
		}
	}
	public Node KthOrderStaticElement(Node node,int k) {
		
		int r;
		if(k <= 0 || node == null) {
			System.out.println("invalid input value");
			return null;
		}
		
		if(node.left != null)
			r = node.left.lcount + 1;
		else 
			r = 1;
		
		if(k == r) {
			//System.out.println("The " + i + "smallest element is " + node.value);
			return node;
		}else if(k < r)
			return KthOrderStaticElement(node.left, k);
		else
			return KthOrderStaticElement(node.right, k-r);
	}
	public void printKthSmallestElement(Node node,int k) {
		
		Node resultNode = KthOrderStaticElement(node, k);
		if(resultNode != null )
			System.out.println("The " + k + "th smallest element is " + resultNode.value);
		else 
			System.out.println("Couldn't find the required value");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new kthorderStatic();
	}

}
