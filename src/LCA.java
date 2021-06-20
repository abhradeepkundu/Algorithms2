public class LCA {

	public LCA() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	/**
	 *  Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		Node parent;
		int value;
		int lcount =1;
		
		public Node(int val) {
			this.value = val;			
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(25);
		insertNode(rootNode,35);
		insertNode(rootNode,37);
		insertNode(rootNode,39);
		insertNode(rootNode,38);
		insertNode(rootNode,43);
		insertNode(rootNode,42);
		insertNode(rootNode,15);
		insertNode(rootNode,12);
		
		insertNode(rootNode,17);
		insertNode(rootNode,19);
		insertNode(rootNode,36);
		inorder(rootNode);
		
		LeastCommonAncestor(rootNode,rootNode.left.right,rootNode.right);
		System.out.println();
		
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
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	
/**
 * function to find Lowest common Ancestor of a given node
 * 
 * */
	public void LeastCommonAncestor(Node root,Node node1,Node node2) {
		
		if(node1 == null || node2 == null || root == null)
			return;
		
		if(root == node1 || root == node2)
			System.out.println("Given input is invalid");
		
		if(root.left != null && (root.left == node1 || root.left == node2))
			System.out.println("LCA is " + root.value);
		
		if(root.right != null && (root.right == node1 || root.right == node2))
			System.out.println("LCA is " + root.value);
		
		if(node1.value < root.value && root.value < node2.value)
			System.out.println("LCA is " + root.value);
		
		if(node1.value < root.value && node2.value < root.value)
			LeastCommonAncestor(root.left,node1,node2);
		
		if(node1.value > root.value && node2.value > root.value)
			LeastCommonAncestor(root.right,node1,node2);
		
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
		inorder(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new LCA();
	}

}
