 public class InorderandPreorder {

	public InorderandPreorder() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public static class Node {
		Node left;
		Node right;
		char value;
		public Node(char val) {
			this.value = val;
		}
	}
	char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
	char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
	
	public void run() {
		Node root = InPre(0,pre.length -1 ,0,in.length - 1);
		
		inorder(root);
	}
	
	
	/**
	 * Inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		inorder(node.right);
	}
	/***
	 * function to search the index of the rootIndex
	 * */
	int searchRootIndex(char c) {

		for(int i = 0; i < in.length; i ++) {
			if(in[i] == c)
				return i;			
		}	
		return -1;
	}
	/***
	 * Constructing a Tree from inorder and postorder arrays
	 * */
	public Node InPre(int psi, int pei, int isi, int iei) {

		if (psi < in.length) {
			Node node = new Node(pre[psi]);

			if (psi == pei)
				return node;

			int rootIndex = searchRootIndex(pre[psi]);

			int psil = psi + 1;
			int peil = rootIndex;
			int isil = isi;
			int ieil = rootIndex - 1;

			int psir = rootIndex + 1;
			int peir = pei;
			int isir = rootIndex + 1;
			int ieir = iei;

			node.left = InPre(psil, peil, isil, ieil);
			node.right = InPre(psir, peir, isir, ieir);

			return node;
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Shams");
		
		new InorderandPreorder();
	}
}
