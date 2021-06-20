


public class InOrderSucc_Practice {

	public InOrderSucc_Practice() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public static class Node {
		Node left;
		Node right;
		Node parent;
		int value;
		Node(int val,Node parent) {
			this.value = val;
			this.parent = parent;
		}
	}
	public void run() {
		Node rootNode = new Node(25,null);
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
		inOrderSuccessor(rootNode.left.right.right);
	}
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val < node.value) {
			if(node.left == null)
				node.left = new Node(val,node);
			else
				insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val,node);
			else
				insertNode(node.right,val);
		}
	}
	public Node GetMinVal(Node node) {
		Node succ = node.right;
		while(succ.left != null ) {
			succ = succ.left;
		}
		return succ;
	}
	public void inOrderSuccessor(Node node) {
		Node curNode = node;
		if(node == null)
			return;
		if(node.right != null) {
			Node succ = GetMinVal(node);
			System.out.println("Inorder successor of " + curNode.value + " is " + succ.value);
		}else {
			Node p = node.parent;
			while(p != null && node == p.right) {
				node = p;
				p = p.parent;
			}
				System.out.println("Inorder successor of " + curNode.value + " is " + p.value);
		}		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InOrderSucc_Practice();
	}

}
