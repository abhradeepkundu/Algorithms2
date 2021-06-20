public class postorderIterative {

	public postorderIterative() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	private static final int STACKSIZE = 50;
	private int top = -1;
	private void run() {
		// TODO Auto-generated method stub
		Node[] s = new Node[STACKSIZE];
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
		postRecursive(root);
		System.out.println();
		postIterative(root,s);
	}
	public enum Color {
		   WHITE, RED, BLUE
		 }
	public static class Node {
		int value;
		Node left;
		Node right;
		Color color;
		Node(int val) {
			this.value = val;
			this.color = Color.WHITE;
		}
	}
	public boolean isStackEmpty() {
		if(top < 0)
			return true;
		
		return false;
	}
	public boolean isStackFull() {
		if(top >= STACKSIZE)
			return true;
		
		return false;
	}
	public void push(Node[] s,Node node) {
		if(isStackFull()) {
			System.out.println("Stack is FULL !!");
			return;
		}
		s[++top] = node;
	}
	public Node pop(Node[] s) {
		if(isStackEmpty()) {
			System.out.println("Stack is Empty !!");
			return null;
		}
		Node node = s[top--];
		return node;
	}
	public void postRecursive(Node node) {
		if(node == null)
			return;
		postRecursive(node.left);
		postRecursive(node.right);
		System.out.print(node.value +  " ");		
	}
	/**
	 * function to insert Nodes in the Tree
	 * By Shams on 28 Aug 11
	 * */
	public void postIterative(Node node,Node[] s) {
		if(node == null)
			return;
		push(s,node);
		while(! isStackEmpty()) {
			node = pop(s);
			if(node.color.equals(Color.BLUE)) {
				node.color = Color.RED;
				System.out.print(node.value + " ");				
			}else {
				node.color = Color.BLUE;
				push(s,node);
				if(node.right != null)
					push(s,node.right);
				if(node.left != null)
					push(s,node.left);					
			}
		}
	}
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val < node.value) {
			if(node.left == null)
				node.left = new Node(val);
			else
				insertNode(node.left, val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else 
				insertNode(node.right,val);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new postorderIterative();
	}

}
