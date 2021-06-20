public class kthLargestInmatrix {

	public kthLargestInmatrix() {
		this.run();
	}
	
	int a[][] = {
			{10, 20, 30, 40},
	        {15, 25, 35, 45},
	        {24, 29, 37, 48},
	        {32, 33, 39, 50}
	        };

	 int b[][] = {
			 { 2, 3, 4, 5},
	         { 7, 8, 9,10},
	         {12,13,14,15},	         
	         {22,23,24,25}
	         };
	 
	 public static class Node {
		 int val;
		 int r;
		 int c;
	 }
	public void run() {
		int k = 4;
		System.out.println( k+"th smallest element is : " + kthSmallestInMatrix(a,k,a.length));
	}

	//public int heapLength = T.length -1;
	public int kthSmallestInMatrix(int[][] a,int k, int n) {		
		Node T[] = new Node[(a[0].length)];
		int kthSmallest = -1;
		// Base case :: check if k greater than no. of elements in a 
		if(k < 0 || k > (n*n)) {
			System.out.println("invalid k");
			return -1;
		}
		for(int i=0;i<a[0].length;++i) {
			T[i].val = a[0][i];
			T[i].r = 0;
			T[i].c = i;
		}
		//BuildMaxHeap(T);
		
		for(int i = 0; i<k; i++) {
			kthSmallest = T[0].val;
			T[0].val = (T[0].r < (n-1)) ? a[T[0].r+1][T[0].c] : Integer.MAX_VALUE;
			
			heapify(T,T.length-1,0);
		}
		return kthSmallest;
	}
	
	
	public int i = a.length - 1;
	public int j = a.length - 1;

	
	/**
	 * print diagonal elements from bottom right
	 * */
	public int getDiagonalElements(int[][] a) {
		
		//while(i >= 0 ) {
			
		if(i >= 0) {		
		int element = a[i][j];
			if(i == 0) {
				i = j - 1;
				 j= 0;			
			}
			else if(j == a.length - 1) {				
				j = i - 1;i = a.length - 1;
			}else {
				i--;j++;
			}
		//}
			return element;
		}else {
			//System.out.println("End of elements");
			return -1;
		}
	}
	
	/**
	 * function to find kth largest element in the matrix
	 * */

int count =0;
// n - number of rows in the matrix


	private int getNextSmaller(int[][] a, int curSmaller,int r, int c) {
		//if(curSmaller )
		r = r+1;
		return a[r][c];
	}

	/**
	 * Function to Build Max Heap
	 * */
	public void BuildMaxHeap(Node[] T) {
		for(int i = (T.length)/2; i>=0;i++) {
			heapify(T,T.length-1,i);
		}
	}
	
	/**
	 * print matrix elements diagonally
	 * */
	
	public void printMatrixDiagonally(int[][] a) {
		int i = 0, j = 0;
		//System.out.print(a[i][j]);
		while(j < a.length) {
		System.out.print(a[i][j]  + " ");
		if(j == a.length - 1) {
			j = i + 1;
			i = a.length - 1; 
			//System.out.println("i => " + i + " j => " + j);
		}
		else if( i == 0) {
			i = j + 1;
			j = 0 ;			
		}
		else {
			i--; j++;
		}
	}
}
	
	/**
	 * Build Max heap for 2d Array
	 * */
	
	
	/**
	 * return left child
	 * */
	int LEFT(int i) {
		return 2 * i + 1;
	}
	/**
	 * return right child
	 * */
	int RIGHT(int i) {
		return 2 * i + 2;
	}
	
	/**
	 * heapify()
	 * */

	public void heapify(Node[] T,int len,int i) {
		int largest;
		Node temp;
		int left = LEFT(i);
		int right = RIGHT(i);

		if(left <= len && T[left].val > T[i].val)
			largest = left;
		else
			largest = i;
	
		if(right <= len && T[right].val > T[largest].val)
			largest = right;
		if(i != largest) {			
			temp = T[i];
			T[i] = T[largest];
			T[largest] = temp;			
			heapify(T,len,largest);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new kthLargestInmatrix();
	}

}
