public class BFS {

	public BFS() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	private static final int QSIZE = 50;
	private int rear = -1;
	private int front = 0;
	private void run() {
		// TODO Auto-generated method stub
		Node[] Q = new Node[QSIZE];
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
		BFSIterative(root,Q);
	}	
	public static class Node {
		int value;
		Node left;
		Node right;	
		Node(int val) {
			this.value = val;			
		}
	}
	public boolean isQEmpty(int f,int r) {
		if(f > r)
			return true;
		
		return false;
	}
	public boolean isQFull(int f,int r) {
		if(r >= QSIZE)
			return true;
		
		return false;
	}
	public void Enqueue(Node[] Q,Node node) {
		if(isQFull(front, rear)) {
			System.out.println("Queue is Full!!");
			return;
		}
		Q[++rear] = node;
	}
	public Node Dequeue(Node[] Q) {
		if(isQEmpty(front,rear)){
			System.out.println("Queue is Empty");
			return null;
		}
		Node node = Q[front++];
		return node;
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
	 * iterative BFS Function
	 * */
	public void BFSIterative(Node node,Node[] Q) {
		if(node == null)
			return;
		Enqueue(Q,node);
		while(!isQEmpty(front, rear)) {
			node = Dequeue(Q);
			if(node.left != null)
				Enqueue(Q, node.left);
			
			if(node.right != null)
				Enqueue(Q, node.right);
			
			System.out.print(node.value + " ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BFS();
	}
}
