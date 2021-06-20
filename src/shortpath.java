public class shortpath {
	
	public static final int MAX_NODES = 64;
	public static final int MAX_ROWS = 8;
	public static final int MAX_COLS = 8;
	public static final int ZERO = 0;
	shortpath() {
		this.run();
	}
	public static class Node {
		int parent;
		int distance;
		String color;
		Node(String color,int par,int dist) {
			this.color = color;
			this.parent = par;
			this.distance = dist;
		}
	}
	
	/*NxN Knight shortest path / Min moves
	  There are NxN nodes in total
	  two nodes [(x,y) and (a,b)] are connected
	  if a,b < MAX_ROWS and (a,b) is in
	  {(x+1,y+2),(x+1,y-2),(x+2,y+1),(x+2,y-1),(x-2,y-1),(x-2,y+1),(x+2,y+1),(x+1,y-2)}
	  the nodes are numbered in this order

	  00 01 02 03 04 05 06 07
	  08 09 10 11 12 13 14 15
	  16 17 18 19 20 21 22 23
	  24 25 26 27 28 29 30 31
	  32 33 34 35 36 37 38 39
	  40 41 42 43 44 45 46 47
	  48 49 50 51 52 53 54 55
	  56 57 58 59 60 61 62 63
	  
	  */
	private void run() {
		int x1 = 5;int y1 = 3;int x2 = 7; int y2 = 7;
		findPath(x1,y1,x2,y2);
	}
	Node[][] knightMoves= new Node[MAX_NODES][MAX_NODES];
	
	private void findPath(int x1, int y1, int x2, int y2) {

		for(int i=0; i<MAX_NODES ; ++i ) {
			for(int j = 0; j < MAX_NODES;++j) {
				 knightMoves[i][j] = new Node("white", 0 , Integer.MAX_VALUE);	  
			}
		}
		int sourceVertex = (y1 * MAX_ROWS ) + x1;
		int destVertex = (y2 * MAX_ROWS ) + x2;
		System.out.println("source : " + sourceVertex + " dest : " + destVertex);
		for(int i = 0; i < MAX_ROWS; ++i)
			for(int j = 0; j < MAX_COLS;++j)
				populateKnightMoves(i,j);
/*		//for(int i = 0; i < MAX_NODES; ++i)		
			for(int j = 0; j < MAX_NODES;++j)
				if(knightMoves[sourceVertex][j].distance == 1) {
					//ans = (j * MAX_ROWS )+ i; 
						System.out.println("sourceVertex : " + sourceVertex+ " j : " + j );
				}
*/		BFS(knightMoves,sourceVertex);
		System.out.println("Answer : " + getMove(sourceVertex,destVertex));
	}
	public class NodeDetails {
		int parent;
		int distance;
		String color;
		public NodeDetails(String col,int par,int dist) {
			this.parent = par;
			this.distance = dist;
			this.color = col;
		}
	}
	NodeDetails[] storage = new NodeDetails[MAX_NODES];
	private void BFS(Node[][] knightMoves, int sourceVertex) {
		// TODO Auto-generated method stub
		
		for(int i = 0;i < MAX_NODES; ++i) {
			storage[i] = new NodeDetails("white", -1 , 0);	
	        /*storage[i].color = "white"; 
	        storage[i].parent = -1; //Parent Node
	        storage[i].distance = 99; //Distance
	        */
	    }
		int u = sourceVertex;
		System.out.println("source vertex : " + u);
		enqueue(u);
		//knightMoves[u]
		while(!isQEmpty()) {
			u = dequeue1();
			storage[u].color = "gray";
			knightMoves[u][u].parent = 0;
			for(int i = 0; i< MAX_NODES; ++i) {
				if(knightMoves[u][i].distance == 1) {
					System.out.println("u : " + u +"  j : " + i);
					if(storage[i].color.equalsIgnoreCase("white")) {
						storage[i].color = "gray";
						storage[i].parent = u;
						storage[i].distance = storage[u].distance + 1;
						enqueue(i);
					}
					//System.out.println(" sourceVertex : "+ sourceVertex + " parent of " + i+ " is " + sourceVertex);
				}
			}
			storage[u].color = "Black";
		//	System.out.println(" color of "+ u + " is Black");
		}
	}
	int[] q = new int[MAX_NODES * MAX_NODES];
	public static int f = 0;
	public static int r = -1;
	private boolean isQFull() {
		// TODO Auto-generated method stub
		if (r >= q.length)
			return true;
		return false;
	}

	private void enqueue(int u) {
		// TODO Auto-generated method stub
		if (isQFull() ) {
			System.out.println("Q is Full, cannot Enqueue");
			return;
		}	
		
		q[++r] = u;
	}
	private int dequeue1() {
		// TODO Auto-generated method stub
		if (isQFull()) {
			System.out.println("Q is Full, cannot Enqueue");
			return -1;
		}
		int temp = q[f++];
		return temp;
	}

	private boolean isQEmpty() {
		// TODO Auto-generated method stub
		if (f > r)
			return true;
		return false;
	}
	
	public int getMove(int sourceVertex,int destVertex) {
		System.out.print(destVertex + " ==>");
		int result;
		if(storage[destVertex].distance == 0) {
			System.out.println("The is no path from source to destination ");
			return -1;
		}
		result = storage[destVertex].distance;
		
		while(storage[destVertex].parent != sourceVertex) {
			destVertex = storage[destVertex].parent;
			System.out.print(destVertex + " ==>");
		}
		System.out.print(sourceVertex + " ==>");
		System.out.println();
		//System.out.println("The number of steps from " + sourceVertex  + " to " + destVertex + " are " + result );
		return result;
	}
	
	/*NxN Knight shortest path / Min moves
	  There are NxN nodes in total
	  two nodes [(x,y) and (a,b)] are connected
	  if a,b < MAX_ROWS and (a,b) is in
	  {(x+1,y+2),(x+1,y-2),(x+2,y+1),(x+2,y-1),(x-2,y-1),(x-2,y+1),(x+2,y+1),(x+1,y-2)}
	  the nodes are numbered in this order

	  00 01 02 03 04 05 06 07
	  08 09 10 11 12 13 14 15
	  16 17 18 19 20 21 22 23
	  24 25 26 27 28 29 30 31
	  32 33 34 35 36 37 38 39
	  40 41 42 43 44 45 46 47
	  48 49 50 51 52 53 54 55
	  56 57 58 59 60 61 62 63
	  
	  */
	private void populateKnightMoves(int x, int y) {
		// TODO Auto-generated method stub

		/***
		 * from (x,y) co-ordinats knight can move to Max 8 places
		 * calculating the next possible moves of the knight from (x,y) 
		 * */
		int xPlus1  = x + 1;
		int xPlus2  = x + 2;
		int xMinus2 = x - 2;
		int xMinus1 = x - 1;
		
		int yPlus1  = y + 1;
		int yPlus2  = y + 2;
		int yMinus2 = y - 2;
		int yMinus1 = y - 1;
		/**
		 * formula to get next move is (y * (MAX_ROWS|MAX_COLS) + x)
		 * **/
		int currentNode = (y * MAX_ROWS) + x;
		knightMoves[currentNode][currentNode].distance = 0;
		/***
		 * Formula to get the current Number of the node from co -ordinates (x,y)
		 * */

	   if(xPlus2 < MAX_ROWS && yPlus1 < MAX_ROWS) {
	        int adjVertex = ( yPlus1 * MAX_ROWS) + xPlus2 ;
	        	knightMoves[currentNode][adjVertex].distance = 1;
	    }
	    if(xPlus2 < MAX_ROWS && yMinus1 >= ZERO ) {
	        int adjVertex = ( yMinus1 * MAX_ROWS)+ xPlus2;
	        	knightMoves[currentNode][adjVertex].distance = 1;
	    }

	    if(xMinus2 >= ZERO && yPlus1 < MAX_ROWS) {
	        int adjVertex = (yPlus1 * MAX_ROWS )+ xMinus2;
	        	knightMoves[currentNode][adjVertex].distance = 1;
	    }
	    if(xMinus2 >= ZERO && yMinus1 >= ZERO ) {
	        int adjVertex = ( yMinus1 * MAX_ROWS )+ xMinus2;
	        	knightMoves[currentNode][adjVertex].distance = 1;
	    }

	    if(xPlus1 < MAX_ROWS && yPlus2 < MAX_ROWS) {
	        int adjVertex = (yPlus2 * MAX_ROWS ) + xPlus1;
	        	knightMoves[currentNode][adjVertex].distance = 1;
	    }
	    if(xPlus1 < MAX_ROWS && yMinus2 >= ZERO ) {
	        int adjVertex = (yMinus2 * MAX_ROWS )+ xPlus1;
	        	knightMoves[currentNode][adjVertex].distance=1;
	    }

	    if(xMinus1 >= ZERO && yPlus2 < MAX_ROWS) {
	        int adjVertex = ( yPlus2 * MAX_ROWS ) + xMinus1;
	        	knightMoves[currentNode][adjVertex].distance=1;
	    }
	    if(xMinus1 >= ZERO && yMinus2 >= ZERO) {
	        int adjVertex = ( yMinus2 * MAX_ROWS) + xMinus1;	    
	        	knightMoves[currentNode][adjVertex].distance=1;
	    }	    
		return;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new shortpath();
	}
}