import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Arrays {

	public static final int MAX = 5;
	public Arrays() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	 int a[][] = {
			 { 2, 3, 4, 5},
	         { 7, 8, 9,10},
	         {12,13,14,15},	         
	         {22,23,24,25}
	         };
	 int T[] = new int[(a.length * a.length) + 1];
	public void run() {
		
		/*int[] a = {83, 78, 80, 81,79, 82};
		boolean isconsecutive = isConsecutive(a);
		if(isconsecutive)
			System.out.println("The array elements are consecutive");
		else 
			System.out.println("The array elements are not consecutive");*/
	/*		int[] a = {0, 1, 2,2,2,3,4,5,6, 9};
		int result = firstMissing(a,0,a.length -1);
		System.out.println("result - > " + result);*/
		
		
		//getDiagonalElements(a);
		
		//kthLargestInMatrix(a,14);
		sort();
		//int a[] = { 1, 5, 7, 9, 30, 33, 35, 65, 67 };
		int a[] = {15, 2, 4, 8, 9, 5, 10, 23};
	//	int[] a = {1,2,3,4,5};
	//	printArray(a);
		System.out.println();
		//subArraySum2(a,23);
		
		//int[] d = new int[3];
		//combinationUtil(a,d,0,a.length-1,0,3);
		int temp[] = new int[a.length];
	//	mergeSort(a,temp,0,a.length-1);
//		System.out.println();
	//	printArray(a);
		System.out.println();
		//System.out.println("count : " + sumOf2NumbersgreaterThanN(a,42));
		//printReverseArray(a);
		// printMatrixDiagonally(a);
		// System.out.println("result - > " + A.length);
		//int result = isMajority(a);
		//System.out.println( "Result -> " + result);
		/*int ceil = ceilSearch(arr,0,arr.length-1,8);
		System.out.println( "Result -> " + ceil);*/
		//int maxSum = maxSum(a);
		//System.out.println( "Max Sum -> " + maxSum);
		//int res = foo(5);
		//System.out.println("result -> " + res);
//		int[] a = {10, -3, 4, -1, -2, 1, 5, -3};
//		System.out.println(largestSumContiguousSubarray(a));
//
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		//randomize(arr,arr.length);
		//System.out.println(Math.abs(5));
		//int arr[] = {7, 9, 5, 6, 3, 2};
	//	System.out.println(maxdiff(arr));
		//int[] a = {2,-1,7,-1,-1,10,-1};
		
//		int[] a = {2,7,10,0,0,0,0};
//		int[] b = {5,8,12,14};
		//printArray(mergeArray(a,b));
		//printArray(merge2Arrays(a, b, 3, b.length));
//		int[] a = {1, 2, 8, 10, 10, 12, 19};
		//printCeilAndFloor(a,20);
		//int arr[] = {4, 2, 4, 5, 2, 3, 3, 1};
		//printTwoOdd(arr,arr.length);
		//System.out.println(~3);
//		int[] a = {9, 6, 5, 1};
//		System.out.println("Minimum number of coins : " + count(a,11));
		//int a[] =  {1, 2, 1, 3, 4, 2, 3};
        //int k = 4;
        //countDistInWindow(a,k);
		//int[] a1 = {2,9,8,7,6,5};
		int[] a1 = {5,3,4,9,7,6};
//		
//		printArray(a1);
//		System.out.println();
//		
//		System.out.println();
//		
		//int[] res = findNextGreater(a1);
		//printArray(res);
		//int[] a = {0,2,4};
		//printMissing(a);
		//int[] arr = {1,1,0,0,1,0,1,0,1,1};
		//int[] arr = {0,0,0,1,0,0,1,1};
		//int[] arr = {1,1,0,0,1};
		//System.out.println(longestSequence(arr,2));
	}
	
	/***
	 * https://www.careercup.com/question?id=5677751244685312
	 * */
	public static int longestSequence(int [] array, int k){
    	int maxLength = 0;
    	int start = 0;
    	int runningLength = 0;
    	int tmpK = k;
    	
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == 1){
    			runningLength++;
    		}
    		else if(tmpK > 0 && tmpK < k){
    			// intermediate zero in k 0's
    			tmpK--;
    			runningLength++;
    		}
    		else if(tmpK == k){
    			// first zero in the array. i.e the start for k 0's
    			tmpK--;
    			runningLength++;
    			start = i;
    		}
    		else{ //tmpK == 0
    			tmpK = k;
    			maxLength = Math.max(maxLength, runningLength);
    			runningLength = 0;
    			//int tmp = i;
    			i = start;
    			//start = tmp;
    		}
    	}
    	
    	return Math.max(maxLength, runningLength);
    }
	private static void findLongestSequence(int [] array, int k) {
		// TODO Auto-generated method stub
		int maxLength = 0, tempLength = 0, currentIndex = 0, tempFlips = k;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1 && tempFlips >= 0) {
				tempLength++;
				if (i == (array.length - 1) && maxLength < tempLength) {
					maxLength = tempLength;
				}
			} else {
				if (tempFlips == 0) {
					currentIndex++;
					
					tempFlips = k;
					if (maxLength < tempLength) {
						maxLength = tempLength;
					}
					tempLength = 0;
					tempFlips = k;
					i = currentIndex;
				} else {
					tempFlips--;
					tempLength++;
				}
			}
		}
		System.out.println("LongestSequenceLength = " + maxLength);
	}



	public void printMissing(int[] a) {
		for(int i=0;i<(2*a.length);i++) {
			if(a[i] == i)
				i++;
			else {
				System.out.println(i);
				i--;
			}
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
	 * */
	
	private void countDistInWindow(int[] a, int k) {
		int distCount = 1;
		Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i<k;i++) {
			if(hm.get(a[i]) != null) {
				int val = hm.get(a[i]);
				val +=1;
				hm.put(a[i], val);
				distCount--;
			}else {
				hm.put(a[i], 1);
				distCount++;
			}
		}
		System.out.println(distCount);
		for(int i=k;i<a.length;i++) {
			if(hm.get(a[i-k]) > 1) {
				int val = hm.get(a[i-k]);
				val -=1;
				hm.put(a[i-k], val);
			}else {
				hm.remove(a[i-k]);
				distCount--;
			}
			if(hm.get(a[i]) != null) {
				int val = hm.get(a[i]);
				val +=1;
				hm.put(a[i], val);
			}else {
				hm.put(a[i], 1);
				distCount++;
			}
			System.out.println(distCount);
		}
		
	}

	
	// http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	int count( int S[],  int V )
	{
	    // table[i] will be storing the number of solutions for
	    // value i. We need n+1 rows as the table is consturcted
	    // in bottom up manner using the base case (n = 0)
	    int table[] = new int[V+1];
	 
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // Pick all coins one by one and update the table[] values
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<S.length; i++)
	        for(int j=S[i]; j<=V; j++)
	            table[j] += table[j-S[i]];
	 
	    return table[V];
	}
	
	/**
	 * function to print ceil and floor of a given number in a sorted array
	 * http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
	 * */
	
	public void printCeilAndFloor(int[] a,int x) {
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i] <= x && a[i] > floor) 
				floor = a[i];
			if(a[i] >= x && a[i] < ceil)
				ceil = a[i];
		}
		
		if(floor == Integer.MIN_VALUE) 
			System.out.println("Floor does not exist");
		else 
			System.out.println("Floor is : " + floor);
		
		if(ceil == Integer.MAX_VALUE) 
			System.out.println("Ceil does not exist");
		else 
			System.out.println("Ceil is : " + ceil);
	}
	
	/****
	 * function to find the maximum diff between 2 elements in an array, such that greater number appears first
	 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
	 * 
	 * */
	
	public int maxdiff(int[] a) {
		int maxDiff;
		int maxSoFar = a[0];
		int minSoFar = a[0];
		maxDiff = -1;
		for(int i = 1; i < a.length;i++) {
			if(a[i] > maxSoFar) {
				maxSoFar = a[i];
				maxDiff = maxSoFar - minSoFar;
			}else if(a[i] < minSoFar) {
				minSoFar = a[i];
			}
		}
		return maxDiff;
	}
	
	
	public  int[]  merge2Arrays(int[] a, int[] b, int n, int m) 
	{ 
	int k = m + n - 1; // Index of last location of array b 
	int i=n-1;//Index of last element in array b 
	int j=m-1;//Index of last element in array a
	// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
//		while (j >= 0) {
//			a[k--] = b[j--];
//		}
		return a;
	}
	
	/***
	 * Merge an array of size n into another array of size m+n
	 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
	 * */
	
	void moveToEnd(int mPlusN[], int size)
	{
	  int i = 0, j = size - 1;
	  for (i = size-1; i >= 0; i--)
	    if (mPlusN[i] != -1)
	    {
	      mPlusN[j] = mPlusN[i];
	      j--;
	    }
	}
	
	public int[] mergeArray(int[] a,int[] b) {
	moveToEnd(a, (a.length));
	int n = b.length;
	int m = a.length;
	int i = n;  /* Current index of i/p part of mPlusN[]*/
	int j = 0; /* Current index of N[]*/
	int k = 0; /* Current index of of output mPlusN[]*/
	  while (k < m)
	  {
	    /* Take an element from mPlusN[] if
	       a) value of the picked element is smaller and we have
	          not reached end of it
	       b) We have reached end of N[] */
			if ( i < a.length && j < b.length && a[i] <= b[j]) {
				a[k] = a[i];
				k++;
				i++;
			} else // Otherwise take emenet from N[]
			{
				a[k] = b[j];
				k++;
				j++;
		}
		}
		return a;
	}
	
	/**
	 * Function to shuffle the array
	 * **/
	
	void randomize ( int arr[], int n )
	{
	    // Use a different seed value so that we don't get same
	    // result each time we run this program
	 
	    // Start from the last element and swap one by one. We don't
	    // need to run for the first element that's why i > 0
		Random randomGenerator = new Random();
	    for (int i = n-1; i > 0; i--)
	    {
	        // Pick a random index from 0 to i
	        int j = randomGenerator.nextInt(n);
	 
	        // Swap arr[i] with the element at random index
	        swap(arr,i,  j);
	    }
	    printArray(arr);
	}
	
	private void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/***
	 * find subarray for given sum 
	 * */
	// Method 1 : O(n2) complexity
	public void subArraySum(int[] a, int sum) {
		
		for(int i = 0; i < a.length; i++) {
			int cursum = a[i];
			if(sum == cursum) {
				System.out.println("sum is there at index : " + i);
				break;
			}
			for(int j = i+1; j < a.length;j++) {
				cursum +=  a[j];
				if(cursum == sum) {
					System.out.println(" i  : " + i + " j : " + j);
					break;
				}
			}
			cursum = 0;
		}
	}
	// Method 2 :
	public void subArraySum2(int[] a, int sum) {
		int start = 0; int cursum;
		cursum = a[0];
		for(int i = 1; i < (a.length+1); i++) {
			
			while(cursum > sum  && start < i-1) {
				cursum -= a[start];
				start++;
			}
			if(cursum == sum) {
				System.out.println(" start  : " + start + " end : " + (i-1));
				break;
			}

			cursum += a[i];
		}
	}
	
	/***
	 * Method to find the Largest sum contiguous sub array
	 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	 * */
	
	public int largestSumContiguousSubarray(int[] a) {
		int maxSum = a[0];
		int curMax = a[0];
		for(int i = 1;i < a.length; i++) {
			curMax = max(a[i],curMax+a[i]);
			maxSum = max(maxSum,curMax);
		}
		return maxSum;
	}
	/**
	 * function to print the sub arrays of an array
	 * */
	
	void combinationUtil(int arr[], int data[], int start, int end, int index, int r)
	{
	    // Current combination is ready to be printed, print it
	    
		if (index == r)
	    {
			System.out.println();
	        for (int j=0; j<r; j++) {
		        System.out.print( data[j]);
		        
	        }
	        System.out.println();
	        return;
	    }
	    
	 
	    // replace index with all possible elements. The condition
	    // "end-i+1 >= r-index" makes sure that including one element
	    // at index will make a combination with remaining elements
	    // at remaining positions
	    for (int i=start; i<=end && end-i+1 >= r-index; i++)
	    {
	        data[index] = arr[i];
	        combinationUtil(arr, data, i+1, end, index+1, r);
	    }
	}
	
	/****
	 * Given a sorted array, count the sum of 2 numbers greater than n
	 * */
	
	public int sumOf2NumbersgreaterThanN(int[] a,int n) {
		int i = 0; int j = a.length -1;
		int count = 0;
		while(i < j) {
			if( (a[i]+a[j] >= n)) {
				count += (j-i);
				j--;
			}else {
				i++;
			}
		}
		
		return count;
	}
	
	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}
	
	private void printReverseArray(int[] a) {
		// TODO Auto-generated method stub
		for( int i =  a.length-1;i >= 0 ; --i)
			System.out.print(a[i] + " ");
	}


	/****
	 * Function to find the NEXT highest number from the elements of the array
	 * */
	public int mergeSort(int[] a,int[] temp,int left,int right) {
		if(right > left) {
			int mid = (left+right)/2;
			mergeSort(a,temp,left,mid);
			mergeSort(a,temp,mid+1,right);
			merge(a,temp,left,mid,right);
		}
		
		return -1;
	}
	public void merge(int[] a,int[] temp,int left,int mid,int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i <= mid && j <= right) {
			//if(comp(a[i],a[j])) { // compare which is greater ex : 9 & 10 => 910 & 109
			if(a[i] <= a[j])
				temp[k++] = a[i++];
			else 
				temp[k++] = a[j++];
			}
		
		while(i<=mid)
			temp[k++] = a[i++];
		while(j<=right)
			temp[k++] = a[j++];
		for(i=left;i<=right;++i)
			a[i] = temp[i];
	}
	
	public int numdigits(double a) {
		int count = 0;
		while(true) {
			a = a * (0.1);
			count++;
			if(a < 1)
				break;
		}
		return count;
	}
	public long pow(int a,long b) {
		long result = 1;
		for(int i = 0 ; i< b; ++i)
			result = result * a;
		return result;
	}
	boolean comp(long c,long d) {
		//System.out.println("c => " + c + " d => " + d);
		long numc = numdigits(c);
		long numd = numdigits(d);
		
		long a = c * pow(10,numd) + d;
		long b = d * pow(10,numc) + c;
		System.out.println("a => " + a + " b => " + b);
		if(b > a)
			return true;
		else 
			return false;
	}
	
	
	
	
	/***
	 * Find the two numbers with odd occurrences in an unsorted array
	 * http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
	 * */
	
	/* Prints two numbers that occur odd number of times. The
	   function assumes that the array size is at least 2 and
	   there are exactly two numbers occurring odd number of times. */
	void printTwoOdd(int arr[], int size)
	{
	  int xor2 = arr[0]; /* Will hold XOR of two odd occurring elements */
	  int set_bit_no;  /* Will have only single set bit of xor2 */
	  int i;
	  int n = size - 2;
	  int x = 0, y = 0;
	 
	  /* Get the xor of all elements in arr[]. The xor will basically
	     be xor of two odd occurring elements */
	  for(i = 1; i < size; i++)
	    xor2 = xor2 ^ arr[i];
	 
	  /* Get one set bit in the xor2. We get rightmost set bit
	     in the following line as it is easy to get */
	  set_bit_no = xor2 & ~(xor2-1);
	 
	  /* Now divide elements in two sets: 
	    1) The elements having the corresponding bit as 1. 
	    2) The elements having the corresponding bit as 0.  */
	  for(i = 0; i < size; i++)
	  {
	     /* XOR of first set is finally going to hold one odd 
	       occurring number x */
	    if((arr[i] & set_bit_no) > 1)
	      x = x ^ arr[i];
	 
	     /* XOR of second set is finally going to hold the other 
	       odd occurring number y */
	    else
	      y = y ^ arr[i]; 
	  }
	 
	  System.out.println(" The two ODD elements are  "+ x + " and "+ y);
	}
	
	
	void sort() {
//		int[] arr = { 0, 2, 0, 1, 2, 0, 0, 2, 0, 1, 1, 1, 2, 2, 2, 0, 2, 2, 0,
//				0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1 };
		//int[] arr = {0,1,0,2,2,1,0};
		int[] arr = {2,0,1};
		System.out.println("arr len : " + a.length);
		int elem, tmp, zero = 0, two = arr.length - 1, i = 0;
		while (i < arr.length && two >= i) {
			elem = arr[i];
			if (elem == 0) {
				arr[zero++] = elem;
				if (i != 0)
					arr[i] = 1;
				i++;
			}
			if (elem == 2) {
				tmp = arr[two];
				arr[two--] = 2;
				arr[i] = tmp;
			}
			if (elem == 1)
				i++;
		}

		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	
	public int i = a.length - 1;
	public  int j= a.length - 1;

	
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
public int heapLength = T.length -1;
	public void kthLargestInMatrix(int[][] a,int k) {		
		// Build a Max Heap of size 5		
		int max = 0;
		for(int i = 0; i < T.length; i++) 
			T[i] = getDiagonalElements(a);
		
		while(count < T.length && count != k ) {
			max = BuildMaxHeap();
			count++;
		}

		if(count == k)
			System.out.println(" Count => " + count+ "th largest element is => " + max);
		else
			System.out.println("No Matching element");	
	}

	/**
	 * Function to Build Max Heap
	 * */
	public int BuildMaxHeap() {
		int temp;
		
		if(heapLength == -1)
			return -1;
		temp = T[0];
		T[0] = T[heapLength];
		T[heapLength] = temp;
		heapLength--;
		
		heapify(heapLength,0);		
		return temp;
	
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

	public void heapify(int len,int i) {
		int largest;
		int temp;
		int left = LEFT(i);
		int right = RIGHT(i);

		if(left <= len && T[left] > T[i])
			largest = left;
		else
			largest = i;
	
		if(right <= len && T[right] > T[largest])
			largest = right;
		if(i != largest) {			
			temp = T[i];
			T[i] = T[largest];
			T[largest] = temp;			
			heapify(len,largest);
		}
	}

	/**
	 * Function to find the first Missing element in sorted array
	 * */
	public int firstMissing(int[] a,int low,int high) {
		if(high > low) {
			if(a[low] != low)
				return low;
			int mid = (low+high)/2;
			if(a[mid + 1] >= a[mid] && mid<=high) {
				return firstMissing(a, mid+1, high);
			}else{
				return firstMissing(a, 0, mid-1);
			}
		}
		return -1;
	}
	public int foo(int r) {
		if(r == 1)
			return 1;
		if(r == 2)
			return 2;
		return foo(r-1)+foo(r-2);
	}
	public int max(int a,int b) {
//		if(a > b)
//			return a;
//		else
//			return b;
		return a > b ? a : b;
	}
	public int maxSum(int a[]) {
		int[] b = new int[a.length];
		
		b[0] = a[0]; if(a.length == 1) return a[0]; 
		b[1] = a[1]; if(a.length == 2) return max(a[0],a[1]); 
		
		b[2] = a[0]+a[2]; if(a.length == 3) return max(a[1],b[2]); 
		int c,d;
		//System.out.println(b[0] + " " + b[1] + " " + b[2]);
		for(int i=3;i<a.length;i++) {
			//System.out.println("i = " + i + " a[i] = " + a[i] + " b[i-2] = " + b[i-2] + " b[i-3] = " + b[i-3]);
			c = (a[i]+b[i-2]);d= (a[i]+b[i-3]);
			//System.out.println("c = " + c + " d = " + d);			
			b[i] = max(c,d);
		}
		//System.out.println(b[a.length-1] +" " + b[a.length - 2]);
		return max(b[a.length-1],b[a.length - 2]);		
	}
	public int ceilSearch(int a[],int low,int high,int x) {
		System.out.println("coming");
		if(a.length <= 1)
			return -1;
		
		if(x <= a[low])
			return a[low];
		
		if(x > a[high]) {
			System.out.println("x is > than a[high]");
			return -1;
		}
		
		int mid = (low+high)/2;
		System.out.println("mid : " + mid + " arr ele : " + a[mid]);
		if(a[mid] == x)
			return a[mid+1];
		
		else if(a[mid] < x) {
			System.out.println("value of high : " + high + " mid : " + mid);
			if(mid+1 <= high && x <= a[mid+1]) {
				System.out.println("returning : " + a[mid + 1]);
				return a[mid+1];
			}
			else
				return ceilSearch(a, mid+1, high, x);
		}else {
			if(mid-1 >= low && x > a[mid - 1])
				return a[mid];
			else 
				return ceilSearch(a, low, mid-1, x);
		}
		//System.out.println("Returning -1");
		//return -1;
	}

	public int countOccurences(int[] a,int low,int high,int x) {
		if(a.length <= 1) {
			System.out.println("Invalid array");
			return -1;
		}		
		int i,j;
		i = firstOccurence(a,low,high,x);
		if(i == -1)
			return i;
		j = lastOccurence(a,low,high,x);
		return j-i+1;
	}
	private int lastOccurence(int[] a, int low, int high,int x) {
		// TODO Auto-generated method stub
		if(high > low) {
			int mid = (low+high)/2;
			if(mid == high || x == a[mid] && x > a[mid])
				return mid;
			else if(x > a[mid])
				return lastOccurence(a, low, mid-1, x);
			else 
				return lastOccurence(a, mid+1, high, x);
		}
		return -1;
	}

	private int firstOccurence(int[] a, int low, int high,int x) {
		// TODO Auto-generated method stub
		if(high > low) {
		int mid = (low+high)/2;
		if(mid == 0 || x == a[mid] && x > a[mid-1])
			return mid;
		else if(x > a[mid])
			return firstOccurence(a, mid+1, high, x);
		else
			return firstOccurence(a, low, mid-1, x);
		}
		return -1;
	}

	public int isMajority(int a[]) {		
		int x =1;
		int len = a.length;
		System.out.println( "Array length : " + len);
		if(len <= 1)
			return -1;
		int i = _binarySearch(a,0,len,x);
		
		if(i < (len ) && a[(i+len)/2] ==x)
			return 1;
		else 
			return 0;
	}
	public int _binarySearch(int a[],int low,int high,int x) {
		if(high > low) {
			int mid = (low+high)/2;
			if(mid == 0 || a[mid -1] < x && (a[mid] == x))
				return mid;
			if(x > a[mid])
				return _binarySearch(a, mid+1, high, x);
			else
				return _binarySearch(a, low, mid -1, x);
		}
		
		return -1;
	}
	public boolean isConsecutive(int a[]) {
		int max = getmax(a);
		int min = getmin(a);
		
		if( (max - min +1 ) == a.length) {
			for(int i=0;i < a.length;i++) {
				//System.out.println("i " + i+ "-> "+ a[i] );
				int j;
				if(a[i] < 0) {
					j = -a[i] - min;
					System.out.println("coming here : " + a[i] + " " + min + " j : " + j);
				}else {
					j = a[i] -min;
				}
				
				System.out.println("J : " + j);
				if(a[j] > 0)
					a[j] = -a[j];
				else 
					return false;
			}
			return true;
		}
		return false;
	}
	public int getmax(int a[]) {
		int max = a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i] > max)
				max = a[i];
		}		
		return max;
	}
	public int getmin(int a[]) {
		int min=a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i] < min)
				min = a[i];
		}
		return min;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Shams");
			
			
			/**
			 * get max and get min
			 *  1st condition if (max - min + 1 == n )
			 *  all elements should be distinct
			 *  if(a[abs(a[i])] > 0)
			 *  	make it -ve
			 *  else
			 *  	repetitive element
			 * 
			 * */
			
			new Arrays();
	
	}
	
	
	/***
	 * function to find the next greater element of all the digits of an array
	 * http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	 * 02-sep-2015
	 * */
	
	public int[] findNextGreater(int[] a) {
		int i;
		int[] temp = new int[a.length];
		for(i=a.length-1;i>0;i--)
			if(a[i] > a[i-1])
				break;
			if(i <= 0) {
				System.out.println("NOT possible");
				return null;
			}
			int nextGreaterElementIndex = getNextGreaterElement(a, i-1);
			swap(a,i-1,nextGreaterElementIndex);
			mergeSort(a, temp, i, a.length-1);
		return a;
	}


	private int getNextGreaterElement(int[] a, int i) {
		int nextGreatedIndex = -1;
		int nextMax = Integer.MAX_VALUE;
		for(int j = i+1; j< a.length;j++) {
			if(a[i] < a[j] && a[j] < nextMax) {
				nextMax = a[j];
				nextGreatedIndex = j;
			}
		}
		return nextGreatedIndex;
	}
}
