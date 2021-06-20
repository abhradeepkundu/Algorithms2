public class searchPathToNode {

	public searchPathToNode() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		Node root = new Node(25);
		insertNode(root,32);
		insertNode(root,12);
		insertNode(root,15);
		insertNode(root,22);
		insertNode(root,33);
		insertNode(root,42);
		insertNode(root,17);
		insertNode(root,28);
		insertNode(root,11);
		insertNode(root,10);
		insertNode(root,23);
		//inorder(root);
		Node searchNode = root.left.right.right.left;
		//String path = searchPath(root,searchNode);
		String path = printPathToNode(root,searchNode);
		System.out.println("Path to " + searchNode.value + " is " + path);
	}
	public static class Node {
		Node left;
		Node right;
		int value;
		
		Node(int val){
			this.value = val;
		}
	}
	public void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	public void insertNode(Node node,int val) {
		if( node == null) 
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
	
	/***
	 * function to search the path of a given node from in the Binary tree
	 * */
	public String searchPath(Node root,Node node ) {
		if(root == null || node == null) {
			//System.out.println("Either Root or the given input node is NULL");
			return null;
		}
		if(node.value == root.value)
			return "";
		String s1 = searchPath(root.left,node);
		String s2 = searchPath(root.right,node);
		if(s1 != null)
			return  "L" + s1;
		if(s2 != null)
			return "R" + s2;
		
		return null;
	}
	
	//Mon 29-May-2017 5:57AM
	
	public String printPathToNode(Node root,Node node) {
		if(root == null || node == null || node.value == root.value) {
			return "";
		}
		if(root.value < node.value)
			return "R" + printPathToNode(root.right, node);
		else 
			return "L" + printPathToNode(root.left, node);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new searchPathToNode();
	}

}
