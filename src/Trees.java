




public class Trees {

	public Trees() {
		// TODO Auto-generated constructor stub
		this.run();
		
	}

	/**
	 *  Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		Node next;
		int value;
		
		public Node(int val) {
			this.value = val;
		}
	}
	Node[] Q = new Node[100]; 
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	int x = 10;
	public void run() {
/*		Node root = new Node(-2);
		root.left = new Node(-3);
		root.left.left = new Node(-4);
		root.left.right = new Node(2);
		root.right = new Node(-1);
		root.right.left = new Node(3);
		root.right.right = new Node(5);*/
//		Node root = new Node(11);
		//assign(100);
//		root.left = new Node(7);
//		//root.left.left = new Node(3);
//		root.left.right = new Node(9);
//		root.right = new Node(15);
//		root.right.left = new Node(20);
//		root.right.right = new Node(33);
		
		/*insertNode(root,10);
		insertNode(root,3);
		insertNode(root,6);*/
		
		
		//sumTree(root);
		
//		insertNode(root,12);
//		insertNode(root,22);
//		insertNode(root,33);
//		insertNode(root,13);
//		insertNode(root,9);
//		insertNode(root,8);
//		insertNode(root,10);
//		root.right.right.left = new Node(7);
//		inorder(root);
		System.out.println("#######");
		
//		mirrorTree(root);
//		System.out.println();
//		inorder(root);
		Node root = new Node(20);
		insertNode(root,8);
		insertNode(root,22);
		insertNode(root,4);
		insertNode(root,12);
		insertNode(root,14);
		insertNode(root,10);
//		inorder(root);
//		System.out.println();
		//kthlargestInBST(root,3);
	//	kthSmallestInBST(root,3);
		Node[] path = new Node[10];
		//rootToLeafPaths(root,path,0);
		//System.out.println(maxSumRootToLeafPath(root,path,0,0,Integer.MIN_VALUE) );
		//inorder(root);
//		int maxVal = Integer.MIN_VALUE;
//		Node maxnode = new Node(maxVal);
//		
//		int maxSum = getmaxSumNode(root,maxnode);
//		System.out.println("Max sum is " + maxSum);
//		System.out.print("Original Tree : ");
//		inorder(root);
//		Node node = cloneTree(root);
//		//System.out.println(sumTree(root));
//		System.out.println();
//		System.out.print("Cloned Tree : ");
//		inorder(node);
		//printAncestors(root,20);
		//childrenSumProperty(rootNode);
		//inorder(root);
		//levelOrderTraversal(root);
		//printQ();
		//printlevel(rootNode,12);
//		printKDisanceNodes(root,2);
		//isFoldable(root);
//		boolean result = checkifBinaryTreeisBst(root);
//		if(result)
//			System.out.println("The Binary tree is BST");
//		else
//			System.out.println("The Binary tree is NOT BST");
		
//		Node node = new Node(10);
//		node.left = new Node(2);
//		node.left.left = new Node(20);
//		node.left.right = new Node(1);
//		node.right = new Node(10);
//		node.right.right = new Node(-25);
//		node.right.right.left = new Node(3);
//		node.right.right.right = new Node(4);
		Node node = new Node(2);
		node.left = new Node(20);
		node.right = new Node(-1);
		//int max[] = new int[1]; 
		//max[0] = Integer.MIN_VALUE;
		//inorder(node);
		System.out.println();
		findMaxUtil(node);
		System.out.println(max);
		System.out.println();
		//inorder(root);
		//fillinorderSucc(root);
		System.out.println();
		//rootToLeafPaths(root,path,index,30);
		//inorderSucc(root);
	}
	int curMax = Integer.MIN_VALUE;
	int max = 0;
	int findMaxUtil(Node root)
	{
	    //Base Case
	    if (root == null)
	        return 0;
	 
	    // l and r store maximum path sum going through left and
	    // right child of root respectivelyq
	    int l = findMaxUtil(root.left);
	    int r = findMaxUtil(root.right);
	    max = max(root.value+max,max);
	    return max(l+max,r+max,max);
	    // Max path for parent call of root. This path must
	    // include at-most one child of root
//	    int max_single = max(max(l, r) + root.value, root.value);
//	 
//	    // Max Top represents the sum when the Node under
//	    // consideration is the root of the maxsum path and no
//	    // ancestors of root are there in max sum path
//	    int max_top = max(max_single, l + r + root.value);
//	 
//	    max = max(max, max_top); // Store the Maximum Result.
//	 
//	    return max_single;
	}
private int max(int i, int j, int k) {
	int max=0;
	if(i<j)
		max = j;
	if(k>max)
		max=k;
		return max;
	}
//	private int maxPathSum(Node node,int maxSum) {
//		if(node == null)
//			return 0;
//		int lsum = maxPathSum(node.left, curSum, maxSum);
//	    int rsum = maxPathSum(node.right, curSum, maxSum);
//	    
//	    int curSum = Math.max(node.value+lsum, node.value+rsum);   
//		
//		if(curSum > maxSum)
//			maxSum = curSum;
//		System.out.println("max sum : " + maxSum);
//	    
//		return maxSum;
//	}
	private void inorderSucc(Node root) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		inorderSucc(root.left);
		
		if(root.next != null)
			System.out.println("inorder successor of " + root.value + " is " + root.next.value);
		inorderSucc(root.right);
	}
	
	Node next = null;
	public void fillinorderSucc(Node node) {
		if(node == null)
			return;
		
		System.out.println("here " + node.value);
		fillinorderSucc(node.right);
		
		node.next = next;
		next = node;
		
		fillinorderSucc(node.left);
	}
	
	/*****
	 * Function to connect nodes at same level
	 * */
	
	
	/****
	 * 
	 * function to find the kth largest element in BST	
	 * */
	//static int count;
	public int kthlargestInBST(Node node,int k) {
		if(node != null) {
			//System.out.println("coming here " + k + " node "   + node.value + " count : " );
			k = kthlargestInBST(node.right,k);
			
			//count++;
			if(k == 1) {
				System.out.println("kth largest element in BST is " + node.value);
				return -1;
			}
			k--;
			k = kthlargestInBST(node.left,k);
		}
		return k;
	}
	
	/****
	 * 
	 * function to find the kth largest element in BST	
	 * */
	//static int count;
	public int kthSmallestInBST(Node node,int k) {
		if(node != null) {
			//System.out.println("coming here " + k + " node "   + node.value + " count : " );
			
			k = kthSmallestInBST(node.left,k);
			//count++;
			if(k == 1) {
				System.out.println("kth largest element in BST is " + node.value);
				return -1;
			}
			k--;
			k = kthSmallestInBST(node.right,k);
		}
		return k;
	}
	
	
	
	
//	int[] path = new int[10]; 
//	public static int index = 0;
//	public int rootToLeafPaths(Node node,int[] path,int index,int k) {
//		if(node == null)
//			return 0;
//		//System.out.println( "NODE " + node.value + " k => " + k);
//		path[index++] = node.value;
//		if((node.value - k) == 0 && node.left == null && node.right == null) 
//			printpath(path,index);
//		else {
//			
//			rootToLeafPaths(node.left, path,index,k -  node.value);
//			rootToLeafPaths(node.right,path,index, k -  node.value);
//		}
//		return -1;
//	}
	
	public void rootToLeafPaths(Node node,Node[] path,int index) {
		if(node == null)
			return;
		path[index++] = node;
		if(node.left == null && node.right == null) {
			printpath(path, index);
			System.out.println();
			return;
		}
		rootToLeafPaths(node.left, path, index);
		rootToLeafPaths(node.right, path, index);
	}
	public int maxSumRootToLeafPath(Node node,Node[] path,int index,int sum,int maxSum) {
		if(node == null)
			return 0;
		path[index++] = node;
		sum += node.value;
		if(node.left == null && node.right == null) {
			printpath(path, index);
			if(sum > maxSum) {
				maxSum = sum;
			}
			System.out.println();
			return maxSum;
		}
		int lsum = maxSumRootToLeafPath(node.left, path, index,sum,maxSum);
		int rsum = maxSumRootToLeafPath(node.right, path, index,sum,maxSum);
		return max(lsum,rsum);
	}
	
	private int max(int lsum, int rsum) {
		return lsum > rsum ? lsum : rsum;
	}
	private void printpath(Node[] path, int index) {
		for(int i = 0; i < index;++i)
			System.out.print(path[i].value + " -> ");
	}
	private void printpath(int[] path2, int index2) {
		for(int i = 0; i < path2.length;++i)
			System.out.println(path2[i] + " ");		
	}
	int maxVal = Integer.MIN_VALUE; 
	private int getmaxSumNode(Node node, Node maxNode) {
		int sum = 0;
		if(node == null)
			return 0;
		sum += getmaxSumNode(node.left, maxNode);
		sum += node.value;
		sum += getmaxSumNode(node.right, maxNode);
		
		if(sum > maxVal) {
			maxVal =sum;
			maxNode = node;
			System.out.println("Max node's val : " + node.value);
		}
		
		return maxVal;
	}

	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.value) { 
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		inorder(node.right);
	}
	
	public static int f = 0;
	public static int r = -1;
	
	
	
	
	
	/**
	 * function to check Q full
	 * 
	 * */
	public boolean isQfull() {
		
		if(r > 20) // Need to declare this value
			return true;
		
		return false;
	}
	
	/**
	 * function to check Q Empty
	 * 
	 * */
	public boolean isQEmpty() {		
		//System.out.println(" in QEmpty r : " + r + "  f : " + f);
		if(f > r)
			return true;
		
		return false;
	}
	
	/**
	 * function to enqueue the nodes in tree
	 * */
	public void enqueue(Node node) {
	
			if(isQfull()) {
				System.out.println("cannot Enqueue -> Q full");
				return;
			}
				
			Q[++r] = node;
			//System.out.println("Enqueued element : " + Q[r]);
			//System.out.println(" in enqueue r : " + r + "  f : " + f);
	}
	
	/**
	 * function to dequeue the nodes in the Q
	 * 
	 * */
	public Node dequeue() {		
		Node delItem = null;
		if(isQEmpty()) {
			System.out.println("Q Empty");
			return delItem;
		}
		delItem = Q[f++];		
		return delItem;
	}	
	
	/**
	 * level order traversal of a tree
	 * 
	 * */
		
	public void levelOrderTraversal(Node node) {
		
		if(node == null)
			return;
		
		enqueue(node);
		while(! isQEmpty()) {
			node = dequeue();
			
			if(node.left != null)
				enqueue(node.left);
			
			if(node.right != null)
				enqueue(node.right);
			
			System.out.print(node.value + " ");			
		}
				
	/*	else {
			if(node != null)
				System.out.print(node.value + " ");
		
			if(node.left != null)
				enqueue(node.left);
			
			if(node.right != null)
				enqueue(node.right);
			
			if(! isQEmpty()) {
				Node delItem = dequeue();
				Node newNode = new Node(delItem.value);
				newNode.left = delItem.left;
				newNode.right = delItem.right;
				levelOrderTraversal(newNode);
			}else {
				System.out.println("\n We are done !!");
			}
		}*/
	}
	/**
	 * function to check if Binary tree is BST or not
	 * */
//	public boolean checkifBinaryTreeisBst(Node node) {
//		int ldata=0,rdata=0;
//		if(node == null || (node.left == null && node.right == null))
//			return true;
//		
//		else {
//			if(node.left != null)
//				ldata = node.left.value;
//			if(node.right != null)
//				rdata = node.right.value;
//			if((ldata <= node.value) && (node.value >= rdata) && (checkifBinaryTreeisBst(node.left) &&
//			checkifBinaryTreeisBst(node.right)))
//				return true;
//			else 
//				return false;
//		}
//	}
	public boolean checkifBinaryTreeisBst(Node node) {
		if(node == null)
			return true;
		
		if( (node.left != null&& node.left.value > node.value) || (node.right != null && node.right.value < node.value))
			return false;
		
		if(!checkifBinaryTreeisBst(node.left) || !checkifBinaryTreeisBst(node.right))
			return false;
		return true;
	}
	
	/**
	 * function to print the Q elements
	 * */
	public void printQ() {
		for(int i=0;i < Q.length; i++) {
			System.out.print("Q items  "+ Q[i++] + " ");
		}			
	}
	
/**
 * function to print K distance nodes from Root
 * */	
	
	public void printKDisanceNodes(Node node,int k) {
	
		if(node == null)
			return;
		if(k == 0) {
			System.out.println(node.value);
			return;
		}
		printKDisanceNodes(node.left, k-1);
		printKDisanceNodes(node.right, k-1);
	
	}
	//10-May-2016 6:16 AM at BTM 
	private void mirrorTree(Node node) {
		if(node == null)
			return;
		Node left = node.left;
		Node right = node.right;
		node.left = right;
		node.right = left;
		mirrorTree(node.left);
		mirrorTree(node.right);
	}
	
	/**
	 * function to convert the tree to its mirror
	 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
	 * */
	
		public void mirror(Node node) {
			if(node == null)
				return;
			Node temp;
			mirror(node.left);
			mirror(node.right);
			temp = node.right;
			node.right = node.left;
			node.left = temp;
		}
	
	/**
	 * function to check the structure of the tree
	 * */
	
		public boolean isStructureSame(Node a,Node b) {
			if(a == null && b == null)
				return true;
			if((a != null && b != null) && isStructureSame(a.left ,b.left) && isStructureSame(a.right ,b.right) )
				return true; 
			
			return false;
		}
	/**
	 * function to check if tree is Foldable
	 * */
	
		public void isFoldable(Node node) {
			if(node == null)
				return;
			mirror(node.left);
			if(isStructureSame(node.left,node.right)) {
				System.out.println("The given tree is foldable");
			}else {
				System.out.println("The given tree is NOT foldable");
			}
			mirror(node.left);
		}
			
		
	/***
	 * Sum Tree
	 * */
		int sum(Node node) {
			if(node == null)
				return 0;
			return sum(node.left) + node.value + sum(node.right);
		}
		public boolean sumTree(Node node) {
			if(node == null || ( node.left == null && node.right == null) ) 
				return true;
			int ls = sum(node.left);
			int rs = sum(node.right);
			if(  sumTree(node.left) &&  sumTree(node.right)  && ( (ls + rs ) == node.value) ) {
				//System.out.println("returning :"  + node.left.value + node.right.value + node.value);
				return true;
			}
			return false;
		}
	
/**
 * function to print children sum property
 * */
	
	public void childrenSumProperty(Node node) {
		int left = 0,right = 0;
		if(node == null)
			return;
		
		if(node.left == null && node.right == null)
			return;
		
		childrenSumProperty(node.left);
		childrenSumProperty(node.right);
		
		
		if(node.left != null)
			left = node.left.value;
		

		if(node.right != null)
			right = node.right.value;
		
		node.value = left + right; 			
	}
	
	/**
	 * Utility function to get the value of a node
	 * */
	int getLevel(Node node,int k,int level) {
		if(node == null)
			return 0;
		if(node.value == k) {		
			return level;			
		}
		
		 return ( getLevel(node.left,k,level+1) |  getLevel(node.right,k,level+1) );				
	}
	
	/**
	 * Get a level of the given key
	 * */
	public void printlevel(Node node,int k) {
		System.out.println(getLevel(node,k,1));
	}
	
	
	/***
	 * function to print all the ancestors of the given node
	 * */
	public boolean printAncestors(Node node,int key) {
		if(node == null)
			return false;
		if(node.value == key)
			return true;
		if(printAncestors(node.left, key) || printAncestors(node.right, key)) {
			System.out.print(node.value + " " );
			return true;
		}		
		return false;
	}
	
	/***
	 * function to return the clone of a tree
	 * */
	public Node cloneTree(Node root) {
		if(root == null)
			return null;
		//cloneTree(root.left);
		Node newNode = new Node(root.value);
		newNode.left =cloneTree(root.left);
		newNode.right =cloneTree(root.right);
		//cloneTree(root.right);
		return newNode;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Trees();
	}

}
