public class SquareRoot {

	public SquareRoot() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		int x = 37;
//		double result = squareroot(x);
//		System.out.println("result " + result);
	
//		int x=1;
		//int[] a = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//		int[] a = {0,0,0,1,1};
//		int result = searchIndex(a,1,1,x);
//		System.out.println("result => " + result);
		
		double result= powerN(8,4);
		System.out.println("result => " + result);
//		double result = powerNew(0,2);
//		System.out.println("result => " + result);
	//	System.out.println(modularPower(5,13,100000));
		//System.out.println((11201*9));
//		 int a[]= {9,10,5,545,544,56};
		 //int[] temp = new int[a.length];
		//mergeSort(a,temp,0,a.length-1);
		//printArray(a);
		//System.out.println(quotient(18,4));
		
		/*double ans = getAngle(2,22);
		System.out.println("result => " + ans);*/
		//System.out.println(isPowOf3(2187));
	}
	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}

	int quotient(int number, int div) {
		int count = 1;
		while (div * count <= number) {
			//System.out.println((div * count) + "<" + number);
			count++;
		}
		return (count - 1);
	}
	
	private double squareroot(int x) {
//		 TODO Auto-generated method stub
		int i;
		for(i=1;i<(x/2);++i) {
			if((i*i) < x)
				continue;
			else break;
		}//System.out.println(i-1);		
		return binarySearch(i-1,i,x);
//		int k = 0;
//        int square = 0;
//        int inputNum = 0;
//		for(int j=0;j<1;j++) {
//        	boolean flag = false;
//        	String num = "11";
//        	inputNum = Integer.parseInt(num);
//        	square = (k*k);
//        	for(k=1;k<(inputNum/2);++k) {
//        		square = (k*k);
//        		if(inputNum==square) {
//        			System.out.println(0);
//        			flag = true;
//        			break;
//        		}
//				if(square < inputNum)
//					continue;
//				else break;
//			}
//			if(!flag) {
//				if(square-inputNum<k)
//					System.out.println(square-inputNum);
//				else {
//					k--;
//					System.out.println(inputNum-(k*k));
//				}
//			}
//        }
//		return inputNum;
	}

	private double binarySearch(double start, double end, double x) {
		// TODO Auto-generated method stub
		//System.out.println("start " + start  + " end " + end);
		double i = start;
		double j = end;		
		double mid = (i+j)/2;
		if((j-i) < 0.000001)
			return mid;
		if((mid*mid) > x)
			return binarySearch(start, mid, x);
		else if((mid*mid) < x)
			return binarySearch(mid, end, x);
		else return mid;					
	}
	
	
	static int powerofI;
	public int searchIndex(int[]a,int start,int end,int x) {
		if( a[end] == x ) {
			int mid = (start+end)/2;
			if(a[mid] == x && a[mid-1] != x)
				return mid;
			else if(a[mid] != x)
				return searchIndex(a, mid+1, end, x);
			else
				return searchIndex(a, start, mid, x);
		}
		++powerofI;
		int newIndex = (int)Math.pow(2, powerofI); 
		return searchIndex(a, end, newIndex, x);
	}
	
	/**
	 * function to calculate the x power n
	 * */
	public double powerN(int x,int n) {
		double y;
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		if(n == 1)
			return x;
		if((n %2) == 0) {
			y = powerN(x,n/2) ;
			return y * y;
		}else {
			y = powerN(x, (n-1)/2);
			return x * y * y;
		}		
	}
	
	public double powerNew(int x,int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		if(n == 1)
			return x;
		double res = x * powerNew(x, n-1);
		return res;
	}
	
	/***
	 * function to calculate the angle between hour and minute hand
	 * */
	public double getAngle(int h,int m) {
		/** calculate the degree of hour hand past 12'0 clock 
		 *  1 hr 20 mins = (1 * 60 + 20) /2  
		 *  General Equation for degree of hour hand past 12 'o clock :  
		 * H = (Hour * 60 + Minutes) / 2
		 *  (dividing by 2 to get the degree from 0 - 180 degrees)
		 *  
		 *  Minute hand rotates 6 degree per minute
		 *  General Equation for degree of Min hand past 12'0 clock :
		 *  M = 6M
		 *  
		 *  
		 *  General equation : ((60 * h) - 11m)/2
		 */
		return abs((60 * h) - (11 * m))/2;
	}
	
	/****
	 * function to calculate the Modular power - i.e last k digits of n raise to m  
	 * */
	public double modularPower(long base, long exponent,int modulus) {
		long c = 1;
		for(int e = 1;e <= exponent; ++ e) {
			c = (base * c) % modulus;	
			System.out.println(" c : " + c + " e : " + e);
		}
		System.out.println("result => " + c);
		return c;
	}
	
	private double abs(double i) {
		// TODO Auto-generated method stub
		if(i < 0)
			return -i;
		else
			return i;
	}
	
	private int isPowOf3(int n) {
		if(n%3 != 0)
			return 0;
		if(n == 1)
			return 1;
		if(n==0 || n==2 )
			return 0;
		
		if(n==3)
			return 1;
		
		return isPowOf3(n/3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SquareRoot();
	}

}
