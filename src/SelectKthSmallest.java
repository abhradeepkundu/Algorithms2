
public class SelectKthSmallest {

	public SelectKthSmallest() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run() {
		int[] a = {4,7,9,1,3,13,11,6,8,2,10};
		//int result = kthSmallest(a,0,a.length-1,11);
		//int result = kthlargest(a,0,a.length-1,10);
		int result = kthLargestIterative(a,0,a.length-1,7);
		//int result = kthSmallestIterative(a,0,a.length-1,6);
		
		System.out.println("Result => " + result);
	}

	private int kthSmallest(int[] a, int p, int r, int i) {

		if(p == r)
			return a[p];
		int q = Partition(a,p,r);
		int k = q - p + 1;
		
		if(k == i)
			return a[q];
		else if(i < k)
			return kthSmallest(a, p, q-1, i);
		else
			return kthSmallest(a, q+1, r, i-k);			
	}
	private int kthSmallestIterative(int[] a,int p,int r,int i) {
		while(true) {
			if(p == r)
				return a[p];
			int q = Partition(a, p, r);
			int k = q - p + 1;
			if(k == i)
				return a[q];
			else if(i < k) {
				r = q-1;
			}else {
				p = q + 1;
				i = i - k;
			}
		}
	}
	private int kthLargestIterative(int[] a,int p,int r,int i) {
		while(true) {
			if(p == r)
				return a[p];
			int q = Partition(a, p, r);
			int k = r - q + 1;
			if(k == i)
				return a[q];
			else if(i > k) {
				 r = q - 1;
				 i = i - k;
			}else {
				p = q + 1;
				//i = r - k;
			}
		}
	}
	private int kthlargest(int[] a, int p, int r, int i) {
		// TODO Auto-generated method stub
		if(p == r)
			return a[p];
		int q = Partition(a,p,r);
		int k = r - q + 1;
		System.out.println("finding " + k + " th largest element");
		//int k = q - p + 1;;
		
		if(k == i)
			return a[q];
		else if(i > k)
			return kthlargest(a, p, q-1, i-k);
		else
			return kthlargest(a, q+1, r, i);			
	}

	private int Partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int pivot = a[p];
		int i = p + 1;
		int j = r;
		int pivotIndex = 0;
		while(true) {
			while(i < j && a[i] < pivot)
				++i;
			while(j > i && a[j] > pivot)
				j--;
			
			if(i < j)		
				swap(a,i,j);
			else 
				break;
		}
		if( a[j] > a[j - 1])
			pivotIndex = j-1;
		else
			pivotIndex = j;
		
		swap(a,p,pivotIndex);
		
		return pivotIndex;
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.out.println("swapping " + a[i] + " with " + a[j]);
	}

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelectKthSmallest();
	}

}
