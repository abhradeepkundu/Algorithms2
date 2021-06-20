
public class GenerateSpiralMatrix {

	public GenerateSpiralMatrix() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		int a[][] = new int[5][5];
		GenSpiralMatr();
		
	}
	int count = 1;
	private static final int MAXROWS = 5;
	private static final int MAXCOLS = 5;	
	int r = MAXROWS;
	int c = MAXCOLS;
	int k = 0, l = 0;
	int[][] a  = new int[MAXROWS][MAXCOLS];
	public void GenSpiralMatr() { 
		
		int k = 0; int l = 0;
		while(k < r && l < c) {
					
			for(int i = k; i < c; ++i) 
				a[k][i] = count++;
				++k;
			
			for(int i = k; i < r; ++i) 
				a[i][c-1] = count++;
				--c;
			
			if(r > k) { 
				for(int i = c-1; i >= 0 ; --i) 
					a[r-1][i] = count++;
					--r;
			}
			for(int i = r-1; i >= k ; --i) 
				a[i][l] = count++;
				++l;
		}
		/*while(k < r && l < c) {
			 
			for(int i = k; i < c; ++i)
				//System.out.print(a[k][i] + " ");
				a[k][i] = count++;
			++k;
			
			for(int i = k; i < r; ++i)
				//System.out.print(a[i][c-1] + " ");
				a[i][c-1] = count++;
			--c;
			if(r > k) {  // special case to avoid re - printing  10 9 8 7 in this example 
			for(int i = c-1; i >=0; --i)
				//System.out.print(a[r-1][i] + " ");
					a[r-1][i] = count++;
			--r;
			}
			for(int i = r-1; i >=k; --i)
				//System.out.print(a[i][l]  + " ");
					a[i][l] = count++;
			++l;
		}*/
			printArray(a);	
	}
	public void printArray(int[][] a) {
		for(int i = 0;i < a.length; ++i)
			for(int j = 0; j < a.length; ++j)
				System.out.print (a[i][j] + " ");
	}
	/*public void GenSpiralMatr(int[][] a,int order) {
		int p=0,n=0;
		char mov[] = {'u','r','d','l'};
		int i = (order + 1)/2 -1;
		int j = (order + 1)/2 -1;
		int mat[][] = new int[5][5];
		mat[i][j] = ++n;
		while(n < (order * order)) {
			switch(mov[p]) {
			case 'u' : i--;
			break;
			case 'r' : j++;
			break;
			case 'd' : i++;
			break;
			case 'l' : j--;
			break;
			}
			mat[i][j] = ++n;
			System.out.print(mat[i][j] + " ");
			p = (p+1)%4;
			int c=i;
			int d=j;
			switch(mov[p]) {
			case 'u' : i--;
			break;
			case 'r' : j++;
			break;
			case 'd' : i++;
			break;
			case 'l' : j--;
			break;
			}
			if(mat[c][d] != 0)
				p = (p+3)%4;
		}
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenerateSpiralMatrix();
	}

}
