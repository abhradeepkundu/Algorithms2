
public class ProductArray {

	public ProductArray() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		
		int a[] = {10, 3, 5, 6, 2};
		int[] prod = new int[a.length];
		prodArr(a,prod);
		
	}
	public void prodArr(int[] a,int[] prod) {
		int temp =1;
		for(int i =0; i < a.length;++i ) {
			prod[i] = temp;
			temp = temp*a[i];
		}
		printArray(prod);
		temp = 1;
		for(int i = a.length-1;i>=0;--i) {
			prod[i] = prod[i] * temp;
			temp = temp *a[i];
		}
		System.out.println();
		printArray(prod);
	}
	private void printArray(int[] prod) {
		// TODO Auto-generated method stub
		for(int i = 0;i<prod.length;++i)
			System.out.print(prod[i] +" ");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ProductArray();
	}

}
