
public class InversionCount {

	public InversionCount() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		int[] a = {16, 17, 9, 0, 19, 24, 3, 8};
		//int[] a = {3,2,1};
		//int[] a = {5,2,4,7,1,3};
		//int[] a = {2,3,8,6,1,0};
		int[] temp = new int[a.length];
		int result = mergesort(a,temp,0,a.length-1);
		
		//countsort(a,5);
		System.out.println("result => " + result);
		//printArray(a);
//		Node[] arr = new Node[8]; 
//		arr[0] = new Node(16);
//		arr[1] = new Node(17);;
//		arr[2] = new Node(9);
//		arr[3] = new Node(0);
//		arr[4] = new Node(19);
//		arr[5] = new Node(24);
//		arr[6] = new Node(3);
//		arr[7] = new Node(8);
//		Node[] temp1 = new Node[arr.length];
//		mergeSortArrayNodes(arr,temp1,0,arr.length-1);
//		printMergeArray(arr);
	}

	private void printMergeArray(Node[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i].val + "-> " +  arr[i].count);
			System.out.println();
		}
	}

	public static class Node {
		int count;
		int val;
		Node(int cnt) {
			this.val = cnt;
		}
	}
	/***
	 * http://www.geeksforgeeks.org/counting-inversions/
	 * */
	private int mergesort(int[] a, int[] temp, int left, int right) {
		// TODO Auto-generated method stub
		int invCount = 0;
		int mid;
		if(right > left) {
			mid = (left+right)/2;
			invCount = mergesort(a, temp, left, mid);
			invCount += mergesort(a, temp, mid+1, right);
			invCount += merge(a,temp,left,mid+1,right);
		}
		return invCount;
	}
	
	public void mergeSortArrayNodes(Node[] a, Node[] temp, int left, int right) {
		int mid;
		if(left < right) {
			mid = (left+right)/2;
			mergeSortArrayNodes(a,temp,left,mid);
			mergeSortArrayNodes(a, temp, mid+1, right);
			mergeArrayNodes(a,temp,left,mid+1,right);
		}
	}
	
	//16, 17, 9, 0, 19, 24, 3, 8,
	private void mergeArrayNodes(Node[] a, Node[] temp, int left, int mid,int right) {
		int i = left;
		int k = left;
		int j = mid ;
		
		while(i <= mid-1 && j <= right) {
			if(a[i].val <= a[j].val) {
				a[i].count +=  (right -j+1);
				temp[k++] = a[i++];
			}
			else  {
				temp[k++] = a[j++];
			}
		}
		
		while(i <= mid-1)
			temp[k++] = a[i++];
		
		while(j <= right)
			temp[k++] = a[j++];
		
		for(i = left; i <= right; ++i)
			a[i] = temp[i];
	}

	private int merge(int[] a, int[] temp, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int i = left;
		int k = left;
		int j = mid ;
		int invCount = 0;
		
		while(i <= mid-1 && j <= right) {
			if(a[i] <= a[j])
				temp[k++] = a[i++];
			else  {
				invCount = invCount +   mid -i; 
				temp[k++] = a[j++];
			}
		}
		
		while(i <= mid-1)
			temp[k++] = a[i++];
		
		while(j <= right)
			temp[k++] = a[j++];
		
		for(i = left; i <= right; ++i)
			a[i] = temp[i];
		return invCount;
	}

	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InversionCount();
	}

}
