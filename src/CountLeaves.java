public class CountLeaves {

	public CountLeaves() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		Node root = new Node(25);
		/*insertNode(root,32);
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
		*/
		Node left = new Node(30);
		Node right = new Node(3);
		Node leftOfLeft = new Node(40);
		Node leftOfRight = new Node(1);
		Node rightOfLeft = new Node(6);
		Node rightOfRight = new Node(10);
		
		root.left = left;
		root.right = right; 
		root.left.left = leftOfLeft;
		root.left.right = leftOfRight; 
		root.right.left = rightOfLeft;
		root.right.right = rightOfRight; 
		
		
		inorder(root);
		System.out.println();
		//convertToBst(root);
		//int j = 0;
		//Node node = new Node(a[j]);
		//printBst(node);
		//convertToBST(root);
		//System.out.println("BST");
		//inorder(root);
		int LeafCount = leaves(root);
		System.out.println();
		System.out.println("The total number of leaf nodes in the tree are => " + LeafCount);
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
	/**
	 * function to get the max node in the sub tree
	 * */
	public Node getMaxNode(Node node) {
		if(node == null)
			return null;
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	/**
	 * function to get the min node in the sub tree
	 * */
	public Node getMinNode(Node node) {
		if(node == null)
			return null;
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	public void convertToBST(Node node) {
		if(node == null)
			return;
		/*else if(node.left == null && node.right == null)
			return;
		else {*/
		
		int temp;
		Node max = getMaxNode(node.left);
		if(max != null && max.value > node.value) {
			temp = node.value;
			node.value = max.value;
			max.value = temp;
			//convertToBST(node.left);
		}
		Node min = getMinNode(node.right);
		if(min != null && min.value < node.value) {
			temp = node.value;
			node.value = min.value;
			min.value = temp;
			//convertToBST(node.right);
		}
		convertToBST(node.left);
		convertToBST(node.right);
	//}
}
	
	
	
	
	
	
	
	
	
	/**
	 * function to convert binary to BST
	 * */
	/*public Node convertToBST(Node root) {
		if(root == null)
			return null;
		int temp;
		convertToBST(root.left);
		convertToBST(root.right);
		if(root.left != null) {
			if( root.left.value > root.value ) {
				temp = root.value;
				root.value = root.left.value;
				root.left.value = temp;
			}				
		}
		if(root.right != null) {
			if(root.value > root.right.value) {
				temp = root.value;
				root.value = root.right.value;
				root.right.value = temp;
			}				
		}
		
		return root;
	}
	*/
	int[] a = new int[20];
	int i = 0;
	public void convertToBst(Node root) {
		if(root == null)
			return;
		convertToBst(root.left);
		a[i++] = root.value;
		convertToBst(root.right);
			
	}
	void printBst(Node root) {
	
		
		for(int j = 1; j < i; ++j)
			insertNode(root,a[j]);
	}
	
	/**
	 * This function is used to count the leaves in the Tree
	 * */
	public int leaves(Node node){
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		return leaves(node.left)+ leaves(node.right);
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
		new CountLeaves();
	}

}
