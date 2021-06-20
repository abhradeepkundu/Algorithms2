public class Heaps {

	public Heaps() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	//int[] T = { 25, 24, 15, 23, 14, 10, 22, 13, 9, 5, 12, 8, 4, 7, 3, 2 };
	

	public void run() {
		//System.out.println("Array Len => " + T.length);
		//int[] T = {4,1,3,2,16,9,10,14,8,7};
		//int[] T = {4,1,3,2,16,9,10};
		int[] T = {2,-5,6,0,1,3,5,3,9,0,1};
		System.out.println("original Array");
		printArray(T);
		//BuildMaxHeap(T);
		System.out.println();
		//System.out.println("Max Heap Array");
		printArray(T);
		System.out.println("After Heap sort");
		heapSort(T,6);
		//printArray(T);
		
	}

	
	private void heapSort(int[] T,int k) {
		int heapLenght = T.length-1;
		BuildMaxHeap(T);
		
		for(int i=heapLenght;i>=0;--i){
			printArray(T);
			//System.out.println("swapping : " + T[0] + " with : " + T[heapLenght]);
			swap(T,0,i);
//			if(((T.length)-heapLenght)==k) {
//				System.out.println(k + "th : "   + "largest element is : " + T[i] );
//				break;
//			}
			//System.out.println("heapLength : " + heapLenght);
			System.out.println();
			heapLenght -= 1;
			heapify(T,0,heapLenght);
		}
		printArray(T);
	}

	private void swap(int[]T,int i, int j) {
		int temp = T[j];
		T[j] = T[i];
		T[i] = temp;
		//System.out.println("swapping : " + T[i] + " with : " + T[j]);
	}

	public void printArray(int[] T) {
		for (int i = 0; i < T.length; i++) {
			System.out.print(T[i] + " ");		
		}
		System.out.println();
	}

	//public int heapLength = T.length-1;

	/**
	 * function to Build Max Heap
	 * */
	public void BuildMaxHeap(int[] T) {
	/*	int temp;
		if (heapLength >= 0) {
			//System.out.println("Heap Len => " + heapLength);
			temp = T[0];
			T[0] = T[heapLength];
			T[heapLength] = temp;
			heapLength--;
			// System.out.println("Exchanging " + temp + " with " + T[0]);
			// System.out.println("Build Max Heap Returning => " + temp);

			heapify(heapLength, 0);
			return temp;
		} else
			return -1;*/
		int heapLength = T.length -1;
		for( int i = (heapLength/2) ; i >= 0; i--) {		
			heapify(T,i,heapLength);
		}

	}

	public int LEFT(int i) {
		return 2 * i + 1;
	}

	public int RIGHT(int i) {
		return 2 * i + 2;
	}

	public void heapify( int[] T, int i,int heapLength) {
		int largest;
		//int temp;
		int left = LEFT(i);
		int right = RIGHT(i);

		if (left <= heapLength && T[left] > T[i])
			largest = left;
		else
			largest = i;

		if (right <= heapLength && T[right] > T[largest])
			largest = right;
		
		if (largest != i) {		
			swap(T,i,largest);
			heapify(T,largest,heapLength);
		}
	}
	

	/**
	 * function to Build max heap
	 * */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Heaps();
	}

}
