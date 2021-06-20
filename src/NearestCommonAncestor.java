
public class NearestCommonAncestor {

	public NearestCommonAncestor() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		Node root = new Node(25);
		insertNode(root,32);
		insertNode(root,13);
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
		Node searchNode1 = root.left.left;
		Node searchNode2 = root.left.right.right.right;
		NearestCommonAncestorForTwoNodes(root,searchNode1,searchNode2);
		//inorder(root);
	}
	public static class Node {
		Node left;
		Node right;
		int value;
		
		Node(int val){
			this.value = val;
		}
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
	public void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	
	/**
	 * This function returns the path of the given node from root
	 * */
	public String searchPath(Node root,Node node) {
		if(root == null)
			return null;
		if(root.value == node.value)
			return  "";
		String s1 = searchPath(root.left,node);
		String s2 = searchPath(root.right,node);
		if(s1 != null)
			return "L" + s1;
		if(s2 != null)
			return "R" + s2;
		return null;
	}
	/***
	 * This function finds the Nearst common ancestor to given 2 Nodes
	 * */
	
	public void NearestCommonAncestorForTwoNodes(Node root,Node node1,Node node2) {
		if(root == null || node1 == null || node2 == null) {
			System.out.println("Either Root or one of the given 2 nodes are NULL");
			return;
		}
		if(root == node1 || root == node2) {
			System.out.println("Root itself is one of the given 2 Nodes");
			return;
		}
		String s1 = searchPath(root,node1);
		String s2 = searchPath(root,node2);
		
		int i=0;
		System.out.println("s1 => " + s1);
		System.out.println("s2 => " + s2);
		// search for the mismatching first sequence

		while(i < s2.length()-1 && i < s1.length()-1 && s1.charAt(i) == s2.charAt(i)) {
			if(s1.charAt(i) == 'L')
				root = root.left;
			else
				root = root.right;
			i++;
		}
		System.out.println("Nearest Common Ancestor of " + node1.value  + " and " + node2.value + " is "+ root.value);		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NearestCommonAncestor();
	}

}
