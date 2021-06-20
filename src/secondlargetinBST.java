
public class secondlargetinBST {

	public secondlargetinBST() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run() {
		Node root = new Node(25);
		insertNode(root, 32);
		insertNode(root, 21);
		insertNode(root, 39);
		insertNode(root, 34);
		insertNode(root, 35);
		insertNode(root, 19);
		insertNode(root, 37);
		insertNode(root, 38);
		insertNode(root, 36);

		inorder(root);
		System.out.println();
		Node secondlargest = secondLargestElement(root);
		if(secondlargest != null)
			System.out.println("The 2nd largest element in the Tree is => " + secondlargest.value);
		else
			System.out.println("NULL");
	}

	public static class Node {
		Node left;
		Node right;
		int value;

		Node(int val) {
			this.value = val;
		}
	}

	public void insertNode(Node node, int val) {
		if (node == null)
			return;
		if (val < node.value) {
			if (node.left == null)
				node.left = new Node(val);
			else
				insertNode(node.left, val);
		} else {
			if (node.right == null)
				node.right = new Node(val);
			else
				insertNode(node.right, val);
		}
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	/**
	 * function to find the 2nd largest element in the BST
	 * */
	public Node secondLargestElement(Node node) {
		if (node == null || node.left == null && node.right == null) {
			System.out
					.println("There is no 2nd largest element exists in the tree");
			return null;
		}
		Node cur = node;
		Node prev = null;
		while (cur.right != null) {
			prev = cur;
			cur = cur.right;
		}		
		if(cur.left != null) {
			cur = cur.left;
			while(cur.right != null)
				cur = cur.right;
			return cur;
		}
		return prev;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new secondlargetinBST();
	}

}
