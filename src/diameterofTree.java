
public class diameterofTree {

	public diameterofTree() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		Node root = new Node(25);
		insertNode(root,35);
		insertNode(root,15);
		inorder(root);
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
	/***
	 * function to calculate the diameter of the tree
	 * */
	public int diameter(Node node) {
		
		return 0;
	}
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
		new diameterofTree();
	}

}
