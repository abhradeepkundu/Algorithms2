public class BuildTreeFromPreInOrderArray {

	public BuildTreeFromPreInOrderArray() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public static class Node {
		char value;
		Node left;
		Node right;

		Node(char val) {
			this.value = val;
		}
	}

	//private static final int ARRAYSIZE = 10;
	private  static int preIndex = 0;
	
	public void run() {
		Node root = preInTree(0, pre.length -1, 0, in.length -1);
		inorderRecursive(root);
	}
	
	char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' ,'G'};
	char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' ,'G'};

	/*
	 * coded on 12 June 2015 by Shams in Cisco BGL 17, 7th floor, B611
	 * */
	private Node preInTree(int psi, int pei, int isi, int iei) {
		if(preIndex < pre.length) {
			Node rootNode = new Node(pre[preIndex++]);
			
			if(psi >= pei)
				return rootNode;
			int rootIndex = search(rootNode.value,psi);
			
			int plsi = psi + 1;
			int plei = rootIndex - 1;
			int ilsi = isi;
			int ilei = rootIndex -1;
			
			int prsi = rootIndex + 1;
			int prei = pei;
			int irsi = rootIndex + 1;
			int irei = iei;
			
			rootNode.left = preInTree(plsi, plei, ilsi, ilei);
			rootNode.right = preInTree(prsi, prei, irsi, irei);
			return rootNode;
		}
		return null;
	}
	
	private int search(char value, int psi) {
		for(int i=psi;i < in.length;++i) {
			if(in[i] == value)
				return i;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * function to build a tree from inorder and preorder Array's By Shams 28
//	 * Aug 11
//	 * */
//
//	private Node preInTree(int psi, int pei, int isi, int iei) {
//		// TODO Auto-generated method stub
//		if (preIndex < in.length) {
//			Node rootNode = new Node(pre[preIndex++]);
//			if (psi >= pei) {
//				System.out.println( "root.value : " + rootNode.value);
//				return rootNode;
//			}
//				
//			
//			int rootIndex = search(rootNode.value, psi);
//			System.out.println("rootIndex is : " + rootIndex + "    root.value : " + rootNode.value);
//
//			
//
//			/*
//			 * plsi -> preorder leftsubtree starting index
//			 */
//			int plsi, plei, prsi, prei;
//			int irsi, irei, ilsi, ilei;
//
//			plsi = psi + 1;
//			plei = rootIndex -1; //  -1 is mandatory here else Right sub tree of B will be C instead of E
//			ilsi = isi;
//			ilei = rootIndex - 1;
//			System.out.println("plse : " + plsi +  "  plei : " + plei + " ilsi :" + ilsi + "  ilei : " + ilei );
//			
//			prsi = rootIndex + 1;
//			prei = pei;
//			irsi = rootIndex + 1;
//			irei = iei;
//			System.out.println("prsi : " + prsi +  "  prei : " + prei + " irsi :" + irsi + "  irei : " + irei );
//			rootNode.left = preInTree(plsi, plei, ilsi, ilei);
//			rootNode.right = preInTree(prsi, prei, irsi, irei);
//
//			return rootNode;
//		} else {
//			//System.out.println("Array bound Index Exceptio");
//			return null;
//		}
//	}
//
//	/**
//	 * function to search the index of the root in inorder Array
//	 * */
//	private int search(char inChar, int isi) {
//		// TODO Auto-generated method stub
//		for (int i = isi; i < in.length; i++)
//			if (in[i] == inChar)
//				return i;
//
//		return 0;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

























	public void inorderRecursive(Node node) {
		if (node == null)
			return;
		inorderRecursive(node.left);
		System.out.print(node.value + " ");
		inorderRecursive(node.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BuildTreeFromPreInOrderArray();
	}

}
