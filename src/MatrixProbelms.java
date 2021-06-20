
public class MatrixProbelms {

	public MatrixProbelms() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		/*int a[][] = { 
				{1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };*/
		int a[][] = { 
				{1,  2,  3, 10},
		        {4,  5,  6, 11},
		        {7,  8,  9, 12},
		        {13, 14, 15, 16}
		    };
		
		//printDiagonal(a);
		//printClockWiseSprialOrder(a,4,4);
		//printAntiClockWiseSprialOrder(a,3,3);
		//rotateClockWiseSpiral(a,3,3);
		int[][] mat = { {1, 2, 3, 4, 12},
                {2, 3, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };
		System.out.println(findCommon(mat));
		int[][] mat1  =  { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		//printMatrix(mat1, 4, 4);
		int n = 303;
		//printMatrixEleDiagonally(mat,4);
		//int result = getnextGreaterPalindrome(n);
			//System.out.println("The next greater palindrome of " + n + " is " + result);
		
		
		//printDiagonalsElementsInMatrix(a);
		//transpose(a);
		
		 char[][] arr = { {'a', 'c', 'd'},
                 		  {'h', 'b', 'e'},
                 		  {'i', 'g', 'f'}
                 		};
		//System.out.println(findLongestConsecutiveCharpath(arr,3,3,'i'));
		 
		 int[][] mat2 = { {1, 2, 9},
         				{5, 3, 8},
         				{4, 6, 7}
         			  };
//		 int[] path = findLongestPathWithDiffOne(mat2,2,2);
//		 printPath(path);
	}
	private void printPath(int[] path) {
		int i=0;
		System.out.println("Printing path");
		while(i<path.length && path[i] !=0) {
			System.out.print(path[i++] + " - ");
		}
	}
	public void transpose(int[][] a) {
		for(int r = 0;r < (a.length );++r)
	    for (int c = r ; c < (a.length);++c )
	        swap(a,r,c);
	    	//swap A(n,m) with A(m,n)
		
		printArray(a);
		for(int r = 0; r < a.length; r++)
		{
		    for(int c =0; c < (a.length)/2; c++)
		    {
		      swapColumns(a,r, c);
		    }
		}
		System.out.println(" ============ ");
		printArray(a);
	}
	private void swap(int[][] a, int r, int c) {
		// TODO Auto-generated method stub
		int temp;
		temp = a[r][c];
		a[r][c] = a[c][r];
		a[c][r] = temp;
	}
	private void swapColumns(int[][] a, int r, int c) {
		// TODO Auto-generated method stub
		int temp;
		temp = a[r][c];
		a[r][c] = a[r][a.length-1-c];
		a[r][a.length-1-c] = temp;
		//System.out.println("swappin " + temp + " with " + a[r][a.length-1-c]);
	}
	public void printArray(int[][] a) {
		for(int i = 0;i < a.length; ++i)
			for(int j = 0; j < a.length; ++j)
				System.out.print (a[i][j] + " ");
	}
	/***
	 * function to find the smallest palindrome greater than given palindrome number 
	 * */
	private int getnextGreaterPalindrome(int n) {
		// TODO Auto-generated method stub
		while(true) {
			++n;
			if(ispalindrome(n))
				break;
		}
		return n;
	}
	
	/****
	 * function to print diagonal elements
	 * */
	public void printDiagonalsElementsInMatrix(int[][] a) {
		int len = 0;
		for (int i = 0; i < a.length; ++i)
			len = len + a[i].length;

		int i = 0;
		int j = 0;
		for (int k = 0; k < len; ++k) {
			if (i < a.length) {
				System.out.print(a[i][j] + " ");
				if (j == a.length - 1) {
					++i;
					j = a.length - 1;
				} else if (i == 0) {
					i = j + 1;
					j = 0;
				} else {
					--i;
					++j;
				}
			}
		}
	}
	
	/****
	 * function to print Diagonal elements of Array from Bottom right
	 * (0,0) , (0,1), (1,0), (0,2)
	 * */
	public void printDiagonal(int[][] a) {
		int element; int i = 0; int j = 0;
		while(j >= 0 && i < a.length) {
			element = a[i][j];
			System.out.print(element + " ");
			if(i == a.length-1 ) {
				i = j + 1;
				j = a.length - 1;
				
			}else if (j == 0 ) {
				j = i + 1;
				i = 0;
				
			}else {
				++i; --j;
			}
		}
	}
	
	/****
	 * function to print Diagonal elements of Array from Bottom right
	 * */
	public void printBottomRight(int[][] a) {
		int element; int i = a.length -1; int j = a.length -1;
		while(i >=0 ) {
			element = a[i][j];
			System.out.print(element + " ");
			if(i == 0 ) {
				i = j -1;
				j = 0;
			}else if (j == a.length -1 ) {
				j = i - 1;
				i = a.length - 1;
				
			}else {
				--i; ++j;
			}
		}
	}

     private boolean ispalindrome(int num) {
		// TODO Auto-generated method stub
    	 int r; int rev = 0;
    	 int n = num; 
    	 while(n > 0) {
    		 r = n % 10;
    		 n = n/10;
    		 rev = rev * 10 + r;
    	 }
    	 if(num == rev)
    		 return true;    	 
		return false;
	}
     // print matrix clock wise spiral format  
	private void printClockWiseSprialOrder(int[][] a, int r, int c) {
		// TODO Auto-generated method stub
		int k = 0; int l = 0;
		while(k < r && l < c) {
			 
			for(int i = k; i < c; ++i)
				System.out.print(a[k][i] + " ");
			++k;
			
			for(int i = k; i < r; ++i)
				System.out.print(a[i][c-1] + " ");
			--c;
			//if(r > k) {  // special case to avoid re - printing  10 9 8 7 in this example 
			for(int i = c-1; i >=l; --i)
				System.out.print(a[r-1][i] + " ");
			--r;
			//}
			for(int i = r-1; i >=k; --i)
				System.out.print(a[i][l]  + " ");
			++l;
		}
	}
	
	// print matrix anti-clock wise spiral format
	
	public void printAntiClockWiseSprialOrder(int[][] a, int R,int C) {
		int k=0;int l=0;
		while(k<=R && l <=C) {
			for(int i=0;i<=R;i++) {
				System.out.print(a[i][l] + " ");
			}
			l++;
			for(int i=l;i<=C;i++) {
				System.out.print(a[R][i]+ " ");
			}
			R--;
			for(int i=R;i>=k;i--) {
				System.out.print(a[i][C]+ " ");
			}
			C--;
			for(int i=C;i>=l;i--) {
				System.out.print(a[k][i]+ " ");
			}
			k++;
		}
	}
	
	
	/***
	 * Print all elements in sorted order from row and column wise sorted matrix
	 * 
	 * Input: mat[][]  =  { {10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50},
                   };
        http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
	 * */
	
	public void printMatrix(int[][] mat,int R,int C) {
		int[] col = new int[C];
		for(int i=0;i<C;i++) {
			col[i] = 0;
		}
		int minIndex = 0;
		int count = 0;
		while(count < (C*C)) {
			int min = Integer.MAX_VALUE;
			for(int i=0; i<R;i++) {
				if(col[i] < C && mat[i][col[i]] < min) {
					min = mat[i][col[i]];
					minIndex = i;
				}
			}
			
			System.out.print(mat[minIndex][col[minIndex]] + " ");
			col[minIndex]++;
			count++;
		}
	}
	
	/**
	 * Function to find a common element in all rows of a given row-wise sorted matrix
	 * mat[4][5] = { {2, 3, 4, 5, 9},
                    {2, 4, 5, 8, 10},
                    {3, 5, 7, 9, 11},
                    {1, 2, 3, 4, 5},
                  };
                  
                  { {1, 2, 3, 4, 12},
                {2, 3, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
	 * http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
	 * **/
	int findCommon(int[][] mat)
	{
	
		int M=4;
		int N=5;
		int[] countIndex = new int[N];
		int minIndex = 0;	
		for(int i=0;i<N;i++) {
			countIndex[i] = N-1;
		}
		while(countIndex[minIndex] >=0) {
			// Find minimum in current last column
			for(int i=0;i<M;i++) {
				if(mat[i][countIndex[i]] < mat[minIndex][countIndex[minIndex]]) {
					minIndex = i;
				}
			}
			
			int commonEleCount = 0;
			for(int i=0;i<M;i++) {
				if(mat[i][countIndex[i]] > mat[minIndex][countIndex[minIndex]]) {
					countIndex[i] -=1;
				}else 
					commonEleCount++;
			}
			if(commonEleCount == M)
				return mat[minIndex][countIndex[minIndex]];
		}
		return -1;
	}
	
	/***
	 * Function to rotate the matrix in clockwise direction
	 * http://www.geeksforgeeks.org/rotate-matrix-elements/
	 * */
	
	public void rotateClockWiseSpiral(int[][] a,int R,int C) {
		int k =0;int l=0;
		int cur = 0;
		int prev = a[cur+1][cur];
		
		while(k<=R && l<=C) {
			for(int i=k; i<=C;i++) {
				cur = a[k][i];
				a[k][i] = prev;
				prev = cur;
			}
			k++;
			for(int i=k; i<=R;i++) {
				cur = a[i][C];
				a[i][C] = prev;
				prev=cur;
			}
			C--;
			for(int i=C;i>=l;i--) {
				cur = a[R][i];
				a[R][i] = prev;
				prev=cur;
			}
			R--;
			for(int i=R;i >=k;i--) {
				cur = a[i][l];
				a[i][l] = prev;
				prev=cur;
			}
			l++;
		}
		System.out.println("here");
	}
	
	/***
	 * print diagonal elements of a matrix
	 * http://www.geeksforgeeks.org/print-matrix-diagonally/
	 * */
	
	public void printMatrixEleDiagonally(int[][] a,int R) {
		for(int i=0;i<R;i++) {
			int k=i; int j=0;
			while(j<=i && k >=0) {
				System.out.print(a[k][j] + " ");
				j++;k--;
			}
		}
		int i = R-1;
		int k=1;
		while(k < R) {
			int j = k; int l = i;
			while(l >=k && j < R) {
				System.out.print(a[l][j] + " ");
				j++;l--;
			}
			k++;
		}
	}
	
	
	/***
	 * Find length of the longest consecutive path from a given starting character
	 * http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a-character-matrix/
	 * */
	
	public int findLongestConsecutiveCharpath(char[][] a, int R, int C,char c) {
		int count =1;
		int x=-1,y=-1,l,m;
		boolean flag = true;
		boolean found = false;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(a[i][j] == c) {
					x=i;y=j;
					found = true;
					break;
				}
			}
			if(found)
				break;
		}
		
		if(x==-1&&y==-1)
			return -1;
		
		while(flag) {
			flag = !flag;
			l=x;m=y;
			if((l+1) < R && y < C && a[l+1][m] - a[x][y] == 1) {
				flag = true;
				count++;
				x = l+1;
				y = m;
			}
			else if((l-1) >= 0 && y < C && (a[l-1][m]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l-1;
				y = m;
			}
			else if(l < R && (y+1) < C && (a[l][m+1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l;
				y = m+1;
			}
			else if(l < R && (y-1) >=0 && (a[l][m-1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l;
				y = m-1;
			}
			else if((l+1) < R && (y+1) < C && (a[l+1][m+1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l+1;
				y = m+1;
			}
			else if((l+1) < R && (y-1) >=0  && (a[l+1][m-1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l+1;
				y = m-1;
			}
			else if((l-1) >= R && (y+1) < C && (a[l-1][m+1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l-1;
				y = m+1;				
			}
			else if((l-1) >= 0 && (y-1) >= 0 && (a[l-1][m-1]-a[x][y] ==1)) {
				flag = true;
				count++;
				x = l-1;
				y = m-1;
			}
		}
		return count;
	}
	
	/***
	 * http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
	 * Given a n*n matrix where numbers all numbers are distinct and are distributed from range 1 to n2, 
	 * find the maximum length path (starting from any cell) such that all cells along the path are increasing order with a difference of 1.
	 * 
	 * ex : 
	 * Input:  mat[][] = 
	 * 			  {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
		Output: 4
		The longest path is 6-7-8-
	 * 
	 * */
	
	private int[] findLongestPathWithDiffOne(int[][] a,int x,int y) {
		int len = (a.length-1) * (a.length-1);
		int[] path = new int[len*len];
		boolean flag = true;
		int R = a.length;
		int C = a.length;
		int k=0;
		if(x <0 || x >= R || y <0 || y >=C) {
			System.out.println("invalid co-ordinates");
			return null;
		}
		path[k++] = a[x][y]; 
		while(flag) {
			flag = !flag;
			if(x+1< R && (y>=0 && y<C) && a[x+1][y]-a[x][y] == 1) {
				path[k++] = a[x+1][y];
				flag = true;
				x++;
			}else if(x-1>=0 && (y>=0 && y<C) && a[x-1][y]-a[x][y]==1) {
				path[k++] = a[x-1][y];
				flag = true;
				x--;
			}else if((x>=0&& x < R) && y+1<C && a[x][y+1]-a[x][y]==1) {
				path[k++] = a[x][y+1];
				flag = true;
				y++;
			}else if((x>=0 && x < R) && y>=0 && a[x][y-1]-a[x][y]==1) {
				path[k++] = a[x][y-1];
				flag = true;
				y--;
			}
			
		}
		return path;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MatrixProbelms();
	}

}
