

public class ConnectNodes {

	public ConnectNodes() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run() {
		
		
		Node root = new Node(15);
		insertNode(root,12);
		insertNode(root,22);
		insertNode(root,33);
		insertNode(root,8);		
		insertNode(root,14);
		insertNode(root,13);
		insertNode(root,35);
		
	//	inorder(root);
		//connectNextNodes(root);
		 printNextNodesAtSamelevels(root);
		//leftView(root,1);
		
		//System.out.println("next of " + root.left.right.right.data + " is " + root.left.right.right.next.data);
		
	}
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.data+ " ");
		inorder(node.right);
	}
	
	
	/**
	 * function to print next nodes
	 * 
	 * */
	public void printNextNodesAtSamelevels(Node node) {
		if(node == null) 
			return;
		System.out.print("The next node of " +node.data );
		if(node.next != null)
			System.out.println( " is " +node.next.data+ " ");
		else {
			System.out.println( " is null");
		}
		printNextNodesAtSamelevels(node.left);
		printNextNodesAtSamelevels(node.right);
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.data) { 
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	/****
	 * function to fill in-order successor of BST
	 * 
			   A--->NULL
		      / \
		     B-->C-->NULL
		    / \   \
		   D-->E-->F-->NULL
			
			   15--->NULL
		      /  \
		     12-->22-->NULL
		    /  \    \
		   8-->14-->33-->NULL
		       /      \
		      13----->35-->NULL     
	 * 
	 * */
	public static class Node{
		Node left;
		Node right;
		Node next;
		int data;
		String color = "white";
		
		Node(int val) {
			this.data = val;
		}
	}
	Node[] s = new Node[STACKLENGTH];
	public final static int STACKLENGTH = 50;
	public static int top = -1;
	
	/**
	 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
	 * 
	 * */
	
	public void connectNextNodes(Node parent) {
		if(parent == null) 
			return;
		
		while(parent != null) {
			Node cur = parent;
			
			while(cur != null) {
				if(cur.left != null) {
					if(cur.right != null) {
						cur.left.next = cur.right;
					}else {
						cur.left.next = getNextRight(cur);
					}
				}
				if(cur.right != null)
					cur.right.next = getNextRight(cur);
				cur = cur.next;
			}
			System.out.println(parent.data);
			if(parent.left != null) {
				parent = parent.left;
			}else if(parent.right != null) {
				parent = parent.right;
			}else 
				parent = getNextRight(parent);
		}
	}
	
	private Node getNextRight(Node cur) {
		if(cur != null) {
			Node temp = cur.next;
			while(temp != null) {
				if(temp.left != null)
					return temp.left;
				if(temp.right != null)
					return temp.right;
				temp = temp.next;
			}
		}
		return null;
	}
	
	/*****
	 * left view of th tree
	 * 
	 * */
	int maxLevelSoFar = 0;
	public void leftView(Node node,int curlevel) {
		if(node == null)
			return;
		
		if(maxLevelSoFar < curlevel) {
			System.out.println(node.data);
			maxLevelSoFar = curlevel;
		}
		leftView(node.left, curlevel+1);
		leftView(node.right, curlevel+1);
	}

//	public void connectNextNodes(Node node) {
//		if (node == null)
//			return;
//		Node next;
//		enqueue(node);
//		while (!isStackEmpty()) {
//			node = dequeue();
//			next = dequeue();
//			/*System.out.print(" node  : " + node.data);
//			if(next != null)
//				System.out.println( " next " + next.data);
//			*/if (node != null) {
//				if (node.color == "blue") {
//					if (next != null) {
//						if (next.left != null) {
//							if(node.color != "blue")								
//								node.next = next.left;
//							if (next.left.left != null) {
//								//next.right.color = "blue";
//								
//								enqueue(next.left.left);
//							} 
//						} else if(next.right != null ){
//							next.right.color = "blue";
//							if(node.color != "blue")
//								node.next = next.right;
//							enqueue(next.right);
//							if(next.right.right != null) {
//								next.right.right.color = "blue";
//								enqueue(next.right.right);
//							}
//						
//						}
//						/*if (next.right != null) {
//							next.right.color = "blue";
//							
//							enqueue(next.right);
//						}
//						if (next.left != null)
//							enqueue(next.left);*/
//					}
//				} else {
//					if (next != null) {
//						node.next = next;
//						enqueue(next);
//					} else {
//						node.next = null;
//					}				
//				}
//				if (node.right != null) {
//					node.right.color = "blue";
//					enqueue(node.right);
//				}
//				if (node.left != null)
//					enqueue(node.left);
//			}
//		}
//	}
		
	

	private Node dequeue() {
		// TODO Auto-generated method stub
		Node temp = null;
		if(isStackEmpty()) {
			return temp;
		}
		temp = s[top--];
		System.out.println("dequeuing : " + temp.data);
		return temp;
	}


	private void enqueue(Node node) {
		// TODO Auto-generated method stub
		if(isStackFull()) {
			System.out.println("stack is full");
			return;
		}
		System.out.println("enqueing  " + node.data + " color : " + node.color);
		s[++top] = node;
	}



	private boolean isStackFull() {
		// TODO Auto-generated method stub
		if(top >= STACKLENGTH) { 
			System.out.println("stack is full");
			return true;
		}
		return false;
	}

	private boolean isStackEmpty() {
		// TODO Auto-generated method stub
		if(top < 0){
			System.out.println("stack is empty");
			return true;
		}
		return false;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ConnectNodes();
	}

}
