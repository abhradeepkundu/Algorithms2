
public class LevelOrderTraversal {

	private static final int MAX_QUEUE_SIZE = 50;

	public LevelOrderTraversal() {
		this.run();
	}

	private void run() {
		
		Node root = new Node(20);
		insertNode(root,21);
		insertNode(root, 16);
		insertNode(root, 10);
		//printInorderTreeTraversal(root);
		//levelOrderTraversal(root);
		levelorderIterative(root);
	}
	
	int front = 0;
	int rear = -1;
	//level order iterative
	public void levelorderIterative(Node node) {
		Node[] queue = new Node[MAX_QUEUE_SIZE];
		if(node==null)
			return;
		push(queue,node);
		while(!isQueueEmpty()) {
			node = dequeue(queue);
			if(node == null)
				return;
			System.out.print(node.value + " ");
			if(node.left!=null)
				push(queue,node.left);
			if(node.right!=null)
				push(queue,node.right);
		}
	}
	

	private Node dequeue(Node[] queue) {
		if(isQueueEmpty()) {
			System.out.println("Queue is Empty, dequeue failed!!");
			return null;
		}
		return queue[front++];
	}

	private boolean isQueueEmpty() {
		if(rear==-1)
			return true;
		return false;
	}

	private void push(Node[] queue, Node node) {
		if(node == null)
			return;
		if(isQueueFull()) {
			System.out.println("Queue is full");
			return;
		}
		queue[++rear] = node;
	}

	private boolean isQueueFull() {
		if(rear >= MAX_QUEUE_SIZE)
			return true;
		return false;
	}

	// Level order recursive 
	private void levelOrderTraversal(Node node) {
		if(node==null)
			return;
		int height = height(node);
		for(int i=1;i<=height;i++) {
			printLevel(node,i);
		}
	}

	private int height(Node node) {
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		if(lheight > rheight)
			return lheight + 1;
		else return rheight + 1;
	}

	private void printLevel(Node node, int level) {
		if(node == null)
			return;
		if(level == 1)
			System.out.print(node.value + " ");
		else {
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}

	private void printInorderTreeTraversal(Node node) {
		if(node == null)
			return;
		printInorderTreeTraversal(node.left);
		System.out.print(node.value + " ");
		printInorderTreeTraversal(node.right);
	}

	private void insertNode(Node root,int val) {
		if(root == null)
			return;
		if(val <= root.value) {
			if(root.left == null) {
				Node newNode = new Node(val);
				root.left = newNode;
			}else {
				insertNode(root.left, val);
			}
		}else {
			if(root.right == null) {
				Node newNode = new Node(val);
				root.right = newNode;
			}else {
				insertNode(root.right, val);
			}				
		}
	}
	public static class Node {
		int value;
		Node right;
		Node left;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static void main(String[] args) {		
		new LevelOrderTraversal();
	}

}
