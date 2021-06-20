import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;


public class Lists {

	public Lists() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	/**
	 *  Structure of the linked list
	 * */
	public static class Node {
		Node next;	
		int value;	
		
		public Node(int val) {
			this.value = val;			
		}
	}
	
	/**
	 *  Structure of the tree
	 * */
	public static class Tree {
		Tree left;
		Tree right;
		int value;	
		
		public Tree(int val) {
			this.value = val;			
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
//		Node head = new Node(4);	
//		head = insertFront(head,3);
//		head = insertFront(head,3);
//		head = insertFront(head,3);
//		head = insertFront(head,2);
//		head = insertFront(head,1);
//	/*	head = insertFront(head,2);				
//		head = insertFront(head,3);
//		head = insertFront(head,1);*/
//		printList(head);
//		Node node = new Node(9);		
//		node = insertFront(node,8);
//		node = insertFront(node,7);
//		node = insertFront(node,4);
//		System.out.println();
		//printList(node);
		//Node ret = AddLists(node,head);
		System.out.println();
		//printList(ret);
		//head = mergesort(head); 		
		//head = AtlReverse(head,3);
		//deleteLastOccurence(head,4);
		System.out.println();
		//printList(head);
		System.out.println();
		//System.out.println(recursiveListLength(head));
		//head = sortLL(head);
		//System.out.println("After merge sort");
		//printList(head);
		//head = findnext(head);
		
		//  1->3->2->1->2->3->2->1->1
		
	//	printList(head);
		System.out.println();
		Node node = new Node(6);		
		//node = insertFront(node,5);
		//node = insertFront(node,7);
		node = insertFront(node,5);
		node = insertFront(node,4);
		node = insertFront(node,3);
		node = insertFront(node,2);
		node = insertFront(node,1);

		//node = insertFront(node,1);
		System.out.println();
		//deleteHigherValueNodes(head);
		
		System.out.println();
		System.out.println();
		printList(node);
		//printList(kAtlReverse(node,3));
		//Node start = AtlReverse(node,3);
		//printList(start);
		//Node start = sortedMerge(head,node);
				
		/*Boolean result = isPalindrome(node);
		if(result)
			System.out.println("List is a Palindrome");
		else 
			System.out.println("List is not a Palindrome");
		//*/	
		
		// http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/#disqus_thread
//		
//		Tree root = new Tree(10);
//		root.left = new Tree(12);
//		root.left.left = new Tree(25);
//		root.left.right = new Tree(30);
//		root.left.right.right = new Tree(50);
//		root.right = new Tree(15);
//		root.right.left = new Tree(36);
//		System.out.println("Tree is : ");
//		inorder(root);
//		System.out.println();
//		System.out.println("Doubly linked list");
//		//Tree p = convertBinaryTreeToDLLUtil(root);
//		Tree p = convertBinaryTreeToDLL2(root);
//		System.out.println();
//		printList(p);
//		
		
		// list for Kway merging
		
		List<Node> input = new ArrayList<Node>();
//		Node head1 = new Node(3);	
//		head1 = insertFront(head1,4);
//		head1 = insertFront(head1,3);
//		head1 = insertFront(head1,2);
//		head1 = insertFront(head1,1);
//		printList(head1);
//		Node head2 = new Node(12);
//		head2 = insertFront(head2,8);
//		head2 = insertFront(head2,1);
//		
//		Node head3 = new Node(3);
//		head3 = insertFront(head3,1);
//		
//		input.add(head1);
//		input.add(head2);
//		input.add(head3);
//		Node curIndex = null;
//		System.out.println("K way list ");
//		for(int i = 0; i < input.size();i++) {
//			curIndex = input.get(i);
//			while(curIndex != null) {
//				System.out.print(curIndex.value + " ");
//				curIndex = curIndex.next;
//			}
//			System.out.println();
//		}
		
//		Node output = kWayMerging(input);
//		if(output != null) {
//			while(output != null) {
//				System.out.print(output.value + " ");
//				output = output.next;
//			}
//		}else {
//			System.out.println("output list is null");
//		}
		System.out.println();
		changePointers(node,node);
		printList(node);
//		head1 = insertFront(head1,2);
//		head1 = insertFront(head1,6);
//		head1 = insertFront(head1,5);
//		head1 = insertFront(head1,11);
//		head1 = insertFront(head1,10);
//		head1 = insertFront(head1,15);
//		head1 = insertFront(head1,12);
		
//		printList(head1);
//		System.out.println();
//		Node node = getNextNum(head1);
//		System.out.println();
//		printList(node);
//		Node node = removeGreaterValNodesOnRight(head1);
//		System.out.println();
//		printList(node);
	}
	
	/***
	 * Remove nodes with greater value on right side of a node
	 * 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. 
	 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
	 * */
	
	public Node removeGreaterValNodesOnRight(Node node) {
		if(node == null)
			return node;
		Node min = new Node(Integer.MAX_VALUE);
		Node cur = node;
		while(cur != null) {
			if(cur.value < min.value) {
				min = cur;
			}else {
				min.value = cur.value;
				min.next = cur.next;
				min = cur;
			}
			cur = cur.next;
		}
		return node;
	}
	
	/***
	 * input : 1->2->3->4->5->6
	 * output :1->6->2->5->3->4 
	 * https://www.careercup.com/question?id=5688549589385216
	 * **/
	private Node changePointers(Node head,Node node) {
		if(head==null || node == null) 
			return head;
		head = changePointers(head,node.next);
		if(head == null)
			return null;
		Node temp = head.next;
		head.next = node;
		node.next = temp;
		head = temp;
		if(temp == node) {
			node.next = null;
			return null;
		}
		return temp;
	}
	private Node kWayMerging(List<Node> input) {
		Node[] countertIndex = new Node[input.size()];
		for(int i = 0; i < input.size(); i++) {
			countertIndex[i] = input.get(i);
		}
		int index;
		Node output = null;
		Node head = null;;
		while(true) {
			index = compareLists(countertIndex);
			if(index == -1)
				break;
			else {
				Node newNode = new Node(countertIndex[index].value);
				countertIndex[index] = countertIndex[index].next;
				if(output == null) {
					output = newNode;
					head = newNode;
				}else {
					output = head;
					while(output.next != null) {
						output = output.next;
					}
					output.next = newNode;
				}
			}
		}
		return head;
	}

	private int compareLists(Node[] countertIndex) {
		int index = -1;
		int min = Integer.MAX_VALUE;
		for(int i =0; i< countertIndex.length; i++) {
			if(countertIndex[i] != null &&  countertIndex[i].value < min) {
				min = countertIndex[i].value;
				index = i;
			}
		}
		return index;
	}

	public void inorder(Tree node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		//System.out.println();
		//System.out.print(node.rcount+ " ");
		inorder(node.right);
	}
	
	
	private void printList(Tree p) {
		if(p == null) {
			System.out.println("List is empty");
		}
		while(p != null) {
			System.out.print(p.value + "<-->");
			p = p.right;
		}
	}

	public Tree convertBinaryTreeToDLLUtil(Tree node) {
		node = convertBinaryTreeToDLL3(node);
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	/**
	 * convert BinaryTree  To DLL
	 * */
	//Method 1
	public Tree convertBinaryTreeToDLL(Tree node) {
		if(node == null)
			return node;
		if(node.left != null) {
			convertBinaryTreeToDLL(node.left);
			node.left = getInorderPredecessor(node.left);
			node.left.right = node;
		}
		if(node.right != null) {
			convertBinaryTreeToDLL(node.right);
			node.right = getInorderSuccessor(node.right);
			node.right.left = node;		
		}
		return node;
	}
	

	private Tree getInorderSuccessor(Tree node) {
		if(node == null)
			return node;
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	private Tree getInorderPredecessor(Tree node) {
		if(node == null)
			return node;
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	//Method 2
	public Tree convertBinaryTreeToDLL2(Tree node) {
		if(node == null)
			return node;
		fixLeftPointers(node);
		//prev = null;
		return fixRightPointers(node);
	}

	private Tree fixRightPointers(Tree node) {
		if(node == null)
			return node;
		while(node.right != null) {
			node = node.right;
		}
		while(node != null && node.left != null) {
			prev = node;
			node = node.left;
			node.right = prev;
		}
		return node;
	}

	Tree prev = null;
	private void fixLeftPointers(Tree node) {
		if(node == null)
			return;
		fixLeftPointers(node.left);
		node.left = prev;
		prev = node;
		fixLeftPointers(node.right);
	}
	
	// Method 3 
	
	public Tree convertBinaryTreeToDLL3(Tree node) {
		if(node == null)
			return node;
		convertBinaryTreeToDLL3(node.left);
		if(prev != null) {
			node.left = prev;
			prev.right = node;
		}
		prev = node;
		convertBinaryTreeToDLL3(node.right);
		return node;
	}


	static int  carry = 0;
	private Node AddLists(Node l1, Node l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		int status = findLength(l1) - findLength(l2);
		Node ret = add(l1, l2,status);
		if(carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = ret;
			ret = newNode;
		}
		return ret;
	}
	private Node add(Node l1, Node l2, int status) {
		if(l1 == null && l2 == null)
			return null;
		Node ret = new Node(0);
		if(status > 0) {
			ret.next = add(l1.next, l2, status-1);
			ret.value = carry + l1.value;
		}else if(status < 0) {
			ret.next = add(l1, l2.next, status+1);
			ret.value = carry + l2.value;
		}else {
			ret.next = add(l1.next, l2.next, 0);
			ret.value = carry + l1.value + l2.value;
		}
		carry = (ret.value)/10;
		ret.value = (ret.value)%10;
		return ret;
	}
	
	
	
	
	
	
	private int recursiveListLength(Node head) {
		if(head == null)
			return 0;
		return 1 + recursiveListLength(head.next);
	}
	/**
	 * function to ADD 2 linked lists on unequal or equal sizes
	 * */
//	public static int carry = 0;
//	public Node AddLists(Node l1,Node l2) {
//		int status = findLength(l1) - findLength(l2);
//		Node ret = add(l1,l2,status);
//		if(carry > 0) {
//			Node newNode = new Node(carry);
//			newNode.next = ret;
//			ret = newNode;
//		}
//		//System.out.println(status);
//		return ret;
//	}
//	private Node add(Node l1, Node l2, int status) {
//		if(l1 == null && l2 == null)
//			return null;
//		Node ret = new Node(0);
//		if(status > 0) {
//			ret.next = add(l1.next,l2,status-1);
//			ret.value = carry + l1.value;
//		}else if(status < 0) {
//			ret.next = add(l1,l2.next,status+1);
//			ret.value = carry + l2.value;
//		}else {
//			ret.next = add(l1.next,l2.next,0);
//			ret.value = carry + l1.value + l2.value;
//		}
//		carry = (ret.value)/10;
//		ret.value = (ret.value)%10;
//		return ret;		
//	}
	private int findLength(Node l) {
		// TODO Auto-generated method stub
		int len = 0;
		while(l.next != null) {
			l = l.next;
			len++;
		}
		return len;
	}
	/***
	 * 
	 * function to delete the last occurence of the give value
	 * */
	
/*	public void deleteLastOccurence(Node head,int x) {
		if(head == null) {
			System.out.println("Head is NULL");
			return;
		}
		Node cur = head;Node prev = null;Node prevOfPrev = null;
		while(cur != null) {
			if(cur.value == x) 
				prev = cur;
				cur = cur.next;					
		}
		if(prev != null)	{
			if(prev.next != null) {
				prev.value = prev.next.value;
				prev.next = prev.next.next;
			}
			else
				prev.next = null;
		}
	}
*/	
	public void deleteLastOccurence(Node head,int x) {
		if(head == null) {
			System.out.println("Head is NULL");
			return;
		}
		Node cur = head;Node prev = cur;Node prevOfPrev = null;
		while(cur != null) {
			if(cur.value == x) {
				prevOfPrev = prev;
				cur = cur.next;
			}else {
				prev = cur;
				cur = cur.next;
			}			
		}
		if(prevOfPrev != null)	{
			System.out.println("prevOfPrev => " + prevOfPrev.value);
			if(prevOfPrev.next.next != null)
				prevOfPrev.next = prevOfPrev.next.next;
			else
				prevOfPrev.next = null;
		}
	}
	
	
	
	
	/***
	 * function to sort the LL
	 * */
	 public Node sortLL(Node head1) {
		 if(head1 == null)
			 return null;
		 Node fast = head1; 
		 Node slow = head1;
		 Node head2 = null;
		 Node resultHead = null;
		 Node prevOfSlow = null;
		 while(fast.next != null && fast.next.next != null) {
			 fast = fast.next.next;
			 prevOfSlow = slow;
			 slow = slow.next;
		 }
		 if(fast.next == null) {
			 head2 = slow.next;
			 // odd number of nodes in the list
			 System.out.println("LL2");
			 printList(head2);
			 slow.next = null;
		 }
		 else {
			 head2 = slow;
			 
			 System.out.println("LL2");
			 printList(head2);
			 prevOfSlow.next = null;			 
		 }
		 System.out.println("LL1");
		 printList(head1);
		 resultHead = sortedMerge(head1,head2); 
		 return resultHead;
	 }
	
	public Node ReverseSecondHalf(Node node) {
		if(node == null)
			return null;
		Node temp,cur=null;
		while(node != null) {
			temp = node;
			node = node.next;
			temp.next = cur;
			cur = temp;
		}
		return cur;
	}
	
	/**
	 * function to check wheather List is a palindrome 
	 * */
	public  boolean isPalindrome(Node node) {
		Node slowPtr,fastPtr,secondhalf,prevOfslowPtr=null;
		if(node == null) {
			System.out.println("List is Empty");
			return false;
		}
		slowPtr = node;
		fastPtr = node;
		while(fastPtr.next != null && fastPtr.next.next != null) {
			prevOfslowPtr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next; 
		}
		// in case of even number of nodes
		if(fastPtr.next != null) {
			secondhalf = ReverseSecondHalf(slowPtr.next);
			slowPtr.next = null;
		}else { // odd number nodes
			secondhalf = ReverseSecondHalf(slowPtr.next);
			prevOfslowPtr.next = null;
		}
		
		
		while(node != null && secondhalf != null) {
			if(node.value != secondhalf.value) {				
				return false;
			}
			else {				
				node = node.next;
				secondhalf = secondhalf.next;
			}
		}
			// Get the Original List
		return true;
	}
	
	/**
	 * function to delete the node in the List if its next has higher value
	 * */
	
	public void deleteHigherValueNodes(Node node) {
		if(node == null)
			return;
		//Node temp;		
		System.out.println();
		while(node.next != null) {
			if(node.next.value > node.value) {
				//temp = node;				
				System.out.print(node.value + "->");
				node = node.next;
				//temp = null;
			}else {
				node = node.next;
			}
		}		
	}

	
	/**
	 * function to merge two sorted Lists
	 * */	
	public Node sortedMerge(Node a, Node b) {
		Node result;
		if(a == null)
			return b;
		if(b == null)
			return a;
		if(a.value < b.value) {
			result = a;
			result.next = sortedMerge(a.next, b);
		}else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		
		return result;
	}
	Node head1;
	Node head2;
	Node result;
	/**
	 * Merge sort for singly LL
	 * **/
	public Node mergesort(Node node) {
		if(node == null || node.next == null)
			return node;
		
		frontbackSplit(node);
			
		mergesort(head1);
		mergesort(head2);
		
		result = sortedMerge(head1, head2);
		return result;
	}
	/***
	 * function to split the list into two halves 
	 * */
	private void frontbackSplit(Node node) {
		head1 = node;
		Node slow = node;
		Node fast = node;
		while(fast != null) {
			fast = fast.next;
			if(fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		head2 = slow.next;
		slow.next = null;
	}

/**
 * function to Reverse the K alternate nodes
 * */	
	
	public Node kAtlReverse(Node node,int k) {
		Node temp,prev = null,cur = node;
		int count = 0;
		
		while(cur != null && count < k) {
			temp = cur;
			cur = cur.next;
			temp.next = prev;
			prev = temp;
			count++;
		}
		if(node !=  null)
			node.next = cur;
		
		count =0;
		while(cur != null && count < k-1) {
			cur = cur.next;			
			count++;
		}		
		if(cur != null)
			cur.next = kAtlReverse(cur.next,k);
		
		return prev;
	}
	

	
	/**
	 * function to Reverse the nodes in group size
	 * */

	public Node AtlReverse(Node node, int k) {
		Node temp, prev = null, cur = node;
		int count = 0;
		while (node != null && count < k) {
			temp = node;
			node = node.next;
			temp.next = prev;
			prev = temp;
			count++;
		}

		if (node != null)
				cur.next = AtlReverse(node, k);

		return prev;
	}
		
	
/**
 * insert the node at the front of the List
 * */	
	
	public Node insertFront(Node head, int val) {
		if(head == null)
			return null;
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	
/***
 * function to return the successor of the given Number
 * */	
	
	public Node findnext(Node node) {
		int quotient = 0;
		if(node == null)
			return null;
		
		node = reverseList(node);
		Node head = node;
		node.value = node.value + 1;
		
		while(node != null && node.value >= 10) {			
				quotient = (node.value) / 10;
				node.value = (node.value) % 10;
				if(node.next == null) {
					Node newNode = new Node(node.value + quotient);
					node.next = newNode;
					node = newNode;
				}else {
					node.next.value = node.next.value + quotient;
				}
			
			node = node.next;
		}		
		node = reverseList(head);		
		return node;
	}
	
	/**
	 * Recursive method
	 * **/
	int carry1 =1;
	public Node getNextNum(Node node) {
		if(node == null)
			return null;
		Node res = nextNum(node);
		if(carry1 > 0) {
			Node newNode = new Node(carry1);
			newNode.next = res;
			res = newNode;
		}
		return res;
	}
	
	
	
	private Node nextNum(Node node) {
		if(node == null)
			return null;
		nextNum(node.next);
		int remainder = (carry1+node.value) %10;
		carry1 = (carry1+node.value)/10;
		node.value = remainder;
		
		return node;
	}

/***
 * function to reverse the List
 * */
private Node reverseList(Node first) {
	// TODO Auto-generated method stub
	if(first == null)
		return null;
	Node temp; Node cur = null;
	while(first != null) {
		temp = first;
		first = first.next;
		temp.next = cur;
		cur = temp;
	}
	return cur;
}
/**
 * print List
 * */	
	public void printList(Node node) {
		
		if(node == null)
			System.out.println("List Empty");
		while(node != null) {
			if(node.next != null)
				System.out.print(node.value + "->");
			else 
				System.out.print(node.value);
			node =node.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Lists();
	}
	
	

}
