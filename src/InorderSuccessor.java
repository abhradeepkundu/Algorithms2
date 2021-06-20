

public class InorderSuccessor {

	public InorderSuccessor() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	/**
	 *  Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		Node inSucc;
		Node parent;
		int value;
		int lcount =1;
		
		public Node(int val,Node par) {
			this.value = val;
			this.parent = par;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(16,null);
		insertNode(rootNode,18);
		insertNode(rootNode,6);
		insertNode(rootNode,8);
		insertNode(rootNode,4);
		insertNode(rootNode,7);
		insertNode(rootNode,5);
		insertNode(rootNode,20);
		insertNode(rootNode,19);
		
		inorder(rootNode);
		System.out.println();
		//inorderSuccessor(rootNode.left.left);	
		//fillInorderSuccessor(rootNode);
		//populateInorderSuccessorForAllNodes(rootNode);
		fillInorderSuccessorNew(rootNode);
		System.out.println();
		inorderSucc(rootNode);
		
		
	}
	private void inorderSucc(Node node) {
		// TODO Auto-generated method stub
		if(node == null) 
			return;
		inorder(node.left);
		if(node.inSucc != null)
			System.out.print("inorder successor of " + node.value + " is "+ node.inSucc.value+ " ");
		else 
			System.out.print("inorder successor of " + node.value + " is null");
		inorder(node.right);
	}
	public Node minval(Node node) {
		Node cur = node.right;
		
		while(cur.left != null)
			cur = cur.left;
		
		return cur;
	}
	/**
	 * function to find inoder successor of a given node
	 *
	 * recoding on 19Jan12
	 * @uthor Shams
	 * */
	public void fillInorderSuccessor(Node node) {
		if(node == null)
			return;
		fillInorderSuccessor(node.left);
		Node succ = getInorderSucc(node);
		node.inSucc = succ;
		if(node.inSucc != null)
			System.out.print("inorder successor of " + node.value + " is "+ node.inSucc.value+ " ");
		System.out.println();
		fillInorderSuccessor(node.right);
	}
	public Node getInorderSucc(Node node) {
		if(node == null)return null;
		
		if(node.right != null)
			return getMinNode(node.right);
		
		Node p = node.parent;
		while(p != null && p.left != node) {
			node = p;
			p = p.parent;			
		}
		return p;
	}
	private Node getMinNode(Node node) {
		// TODO Auto-generated method stub
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public Node fillInorderSuccessorNew(Node node) {
		if(node == null)
			return node;
		
		fillInorderSuccessorNew(node.right);
		prev= node;
		node.inSucc = prev;
		fillInorderSuccessorNew(node.left);
		return node;
	}
	
	Node prev = null;
	public void populateInorderSuccessorForAllNodes(Node node) {
		if(node == null)
			return;
		
		populateInorderSuccessorForAllNodes(node.right);
		node.inSucc = prev;
		if(prev != null)
			System.out.println("Inoder successor of " + node.value + " is  " + prev.value);
		else 
			System.out.println("Inoder successor of " + node.value + " is  null"  );
		prev = node;
		populateInorderSuccessorForAllNodes(node.left);
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
				node.left = new Node(val,node);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val,node);
			else insertNode(node.right, val);
		}
	}
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		//if(node.left != null)
			System.out.print(node.value+ " ");
		inorder(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InorderSuccessor();
	}

}
