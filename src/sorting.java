
public class sorting {

	public sorting() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run() {
		//int[] a = {2,5,3,0,2,3,0,3};
		int[] a = {3,2,7,4,8,5,0,1,6};
		printArray(a);
		insertionSort(a);
		
		//bubblesort(a);
		System.out.println();
		System.out.println("-----------------");
		//insertionSort(a);
		//selectionsort(a);
		//bubblesort(a);
		printArray(a);
		//quicksort(a,0,a.length-1);
		
		
		//mergesort(a,0,a.length-1);
		//printArray(a);
		//dutchFlagSort(0,2);
		//countsort(a,5);
		//printArray(a);
		
	}
	
	/***
	 * function to sort array of 3 elements 0,1,2 - Dutch National Flag
	 * */
	
	public void dutchFlagSort(int low,int high) {
		int[] a  = {0,0,0,1,1,1,0,0,0,2,2,0,0,0};
		int lower = 0; int upper = a.length -1;
		while(lower < a.length && a[lower] == low)
			lower++;
		while(upper >= 0 && a[upper] == high)
			upper--;
		
		int temp = 0; int pivot;
		
		for(pivot = lower; pivot <= upper;) {
			if(a[pivot] == low) {
				temp = a[pivot];
				a[pivot] = a[lower];
				a[lower] = temp;
				lower++;pivot++;				
			}else if(a[pivot] == high) {
				temp = a[pivot];
				a[pivot] = a[upper];
				a[upper] = temp;
				upper--;
			}else {
				pivot++;
			}
		}			  
			  printArray(a);
	}
	
	private void countsort(int[] a,int k) {
		// TODO Auto-generated method stub
		int[] c = new int[k+1];
		int[] b = new int[a.length];
		for(int i=0;i<k;++i)
			c[i]=0;
		for(int i=0;i<a.length;++i)
			c[a[i]] = c[a[i]] + 1;
		for(int i=1;i<=k;++i)
			c[i] = c[i] + c[i-1];
		for(int i=b.length-1 ;i>=0; --i) {
			b[c[a[i]]-1] = a[i];
			c[a[i]] = c[a[i]] - 1;
		}
		
		printArray(b);
	}

	private void mergesort(int[] a,int p,int r) {
		// TODO Auto-generated method stub
		if(p < r) {
			int q = (p+r)/2;
			mergesort(a,p,q);
			mergesort(a,q+1,r);
			//merge(a,p,q,r);
		}
	}

	/*private void merge(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		int[] b = new int[a.length];
		b=a;
		
		for(int i = left; i < right && right < a.length; ++i) {
			if(b[i] <= b[right]) {
				b[i] = a[left];
				left++;
			}else {
				b[i] = a[right];
				right++;
			}				
		}		
	}*/
	public static int SENTINAL = 999;
	
	public void mergerSort(int[] a,int left,int high) {
		
	}

	private void quicksort(int[] a,int p,int r) {
		// TODO Auto-generated method stub
		
		/**
		 * int[] a = {5,2,4,7,10,12,3,8,6}; {5,2,4,3,10,12,7,8,6};
		 * 
		 * 1st iteration : {5,2,4,3,1,7,8,6}
		 * 2nd iteration : {1,2,4,3,5,7,8,6}
		 * 
		 * */
		if( p < r) {
			int q = Partition(a,p,r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
	}

	private int Partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int pivot = a[p];
		int i=p+1;
		int j=r;
		int pivotIndex;
		
		while(true) {
			while(i < j && a[i] < pivot)
				++i;
			while(j > i && a[j] > pivot)
				--j;
			if(i < j)
				swap(a,i,j);
			else
				break;
		}
		if(a[j] > a[j-1])
			pivotIndex = j-1;
		else
			pivotIndex = j;
		swap(a,p,pivotIndex);
		return pivotIndex;
	}

	private void selectionsort(int[] a) {
		int k=0;
		int smallest;
		for(int i = 0;i < a.length;++i){
			smallest = a[i];	
			
			for(int j = i+1;j < a.length;++j) {
				if(a[j] < smallest) {
					smallest=a[j];
					k=j;
				}
			}
			if(k!=0)
				swap(a,i,k);			
		}
	}

	private void bubblesort(int[] a) {
		for(int i = a.length-1; i >=0 ; --i) {
			for(int j = 0; j < i; ++j) {
				if(a[j] > a[j+1]) {
					swap(a,j,j+1);
				}
			}
		}
	}

	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}

//	private void insertionsort(int[] a) {
//		// TODO Auto-generated method stub
//		
//		for(int i = 1; i < a.length; ++i) {			
//			for(int j = i; j > 0 ;--j)
//				if(a[j] < a[j-1]) 
//					swap(a,j,j-1);				
//		}
//	}
	public void insertionSort(int[] a) {
		int i,key;
		for(int j=1;j < a.length;++j) {
			i = j-1;
			key = a[j];
			while(i >= 0 && key < a[i]) {
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
	}

	private void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.out.println();
		//System.out.println("swapping " + a[i] + " with " + a[j] + "      i = " + j + "  j = " + i);
		//printArray(a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new sorting();
	}

}
