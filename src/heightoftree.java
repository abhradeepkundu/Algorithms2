public class heightoftree {

	public heightoftree() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run() {
		Node root = new Node(25);
		insertNode(root,32);
		insertNode(root,13);
		insertNode(root,11);
		insertNode(root,12);
		insertNode(root,15);
		insertNode(root,22);
		insertNode(root,33);
		insertNode(root,42);
		insertNode(root,41);
		insertNode(root,43);		
		insertNode(root,17);
		insertNode(root,28);		
		insertNode(root,10);		
		insertNode(root,23);
		
		inorder(root);
		System.out.println();
		int height = height(root);
		System.out.println("The height of the given tree is => " + height);

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
	 * iterative function to find the calculate the height
	 * */
	public int iterativeHeight(Node node) {
		if(node == null)
			return 0;
		
		return -1;
	}
	
	/**
	 * Recursive function to find the Height of the Tree
	 * */
	public int height(Node node) {
		if(node == null)
			return 0;
		int ls = height(node.left);
		int rs = height(node.right);
		return 1 + max(ls,rs);
	}
	int max(int a, int b){
		if(a > b)
			return a;
		else return b;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new heightoftree();
	}

}
