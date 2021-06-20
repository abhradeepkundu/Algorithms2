
public class PostandIn {

	public PostandIn() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		//Node node = postIn(0,post.length - 1,0,in.length -1);
		Node node = buildTreeFromPostInorderArrays(0,in.length -1);
		inorder(node);
	}
	public static class Node {
		Node left;
		Node right;
		int value;
		Node(int val) {
			this.value = val;
		}
	}
	
	int search(int c) {
		for(int i=0;i < in.length; i ++) {
			if(in[i] == c)
				return i;
		}
		return -1;
	}
	//char[] in = {'4', '8', '2', '5', '1', '6', '3', '7'};
	//char[] post={'8', '4', '5', '2', '6', '7', '3', '1' };
	 int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
     int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
	int postIndex = in.length - 1;
	
//	public Node postIn(int psi,int pei,int isi,int iei) {
//		if(postIndex >= 0) {
//			Node node = new Node(post[postIndex--]);
//			//node.left = null;
//			//node.right = null;
//			if(isi >= iei)
//				return node;
//			int psil,peil,isil,ieil;
//			int psir,peir,isir,ieir;
//			
//			int rootIndex = search(node.value);
//			psil = psi;
//			peil = rootIndex; // special case : no -1 here.. if -1 is there then B comes before E in output
//			isil = isi;
//			ieil = rootIndex -1;
//			
//			psir = rootIndex;
//			peir = pei -1;
//			isir = rootIndex + 1;
//			ieir = iei;
//			
//			
//			node.right = postIn(psir,peir,isir,ieir);
//			node.left = postIn(psil,peil,isil,ieil);
//			
//			return node;
//		}else { 
//			return null;
//		}
//	}
	
	public void inorder(Node node) {
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	
	//Tue 30-Mat-2017 6:03AM
	
	public Node buildTreeFromPostInorderArrays(int isi,int iei) {
		
		if (isi > iei)
			return null;
		Node root = new Node(post[postIndex--]);
//		if (isi == iei)
//			return root;

		int rootIndex = search(root.value);
		root.right = buildTreeFromPostInorderArrays(rootIndex + 1, iei);
		root.left = buildTreeFromPostInorderArrays(isi, rootIndex - 1);
		return root;

	}
	
	
	int search(int arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                break;
        }
        return i;
    }
	
	
	
	
	class Index 
	{
	    int index;
	}
	
//	Node buildTree(int isi,int iei) {
//        // Base case
//        if (isi > iei)
//            return null;
// 
//        /* Pick current node from Preorder traversal using
//           postIndex and decrement postIndex */
//        Node node = new Node(post[postIndex--]);
// 
//        /* If this node has no children then return */
//        if (isi == iei)
//            return node;
// 
//        /* Else find the index of this node in Inorder
//           traversal */
//        int rootIndex = search(in, isi, iei, node.value);
// 
//        /* Using index in Inorder traversal, construct left and
//           right subtress */
//        node.right = buildTree(rootIndex + 1, iei);
//        node.left = buildTree(isi, rootIndex - 1);
// 
//        return node;
//    }
 
    
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new PostandIn();
	}

}
