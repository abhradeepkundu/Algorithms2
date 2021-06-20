

public class inorderSuccWithoutParent {

	public inorderSuccWithoutParent() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		Node root = new Node(4);
		insertNode(root, 5);
		insertNode(root, 2);
		insertNode(root, 3);
		insertNode(root, 1);
		

		inorder(root);
		System.out.println();
		Node searchNode = root.left.right;
		//Node searchNode = root.right.right.right.left;
		System.out.println("Search Node => " + searchNode.value);
		Node inSuccNode = inoderSucc(root,searchNode);
		if(inSuccNode != null)
			System.out.println("The inorder successor of " + searchNode.value + " is => "  + inSuccNode.value);
		else
			System.out.println(searchNode.value + " is the right most node. Hence no inorder successor");
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
	 * This function searches and return the path to the given Node from Root if the Node exists
	 * */
	public String searchpath(Node root,Node node) {
		if(root == null)
			return null;
		if(root.value == node.value)
			return "";
		String s1 = searchpath(root.left,node);
		String s2 = searchpath(root.right,node);
		if(s1 != null)
			return "L" + s1;
		if(s2 != null)
			return "R" + s2;
		return null;
	}
	/**
	 * inorder successor without parent
	 * */
	public Node inoderSucc(Node root,Node node) {
		if(root == null || node == null) {
			System.out.println("Either the root or the given node is NULL");
			return null;
		}
		if(node.right != null) {
			node = node.right;
			while(node.left != null)
				node = node.left;
			return node;
		}else {
			String path = searchpath(root,node);
			System.out.println("Strin Path is => " + path);
			Node cur;
			Node prev = null;
			cur = root;
			
			int i = 0;
			while(i < path.length()) {
				prev = cur;
				
				if(path.charAt(i) == 'R') 					
					cur = cur.right;
				else  {
					cur = cur.left;
					
				}
				i++;	
				//System.out.println(" i : " + i );
				
				/*else 
					return prev;*/
			}
			// incorrect code
			if(cur != prev.right && cur.right == null)
				return root;
			else if(cur == prev.left )
				return prev;
		return null;
		}		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new inorderSuccWithoutParent();
	}

}
