import java.util.ArrayList;
import java.util.Random;
public class Graphs {

	public Graphs() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public static class List {
		int data;
		List next;
	}

	public static class Node {
		String color = "white";
		int data;
		int distance;
		Node parent;
		List adjList;

		Node(int val) {
			this.data = val;
		}
	}

	final int V = 9;
	private void run() {
		ArrayList<Node> node = createGraph(gr);
		BFS1(node, node.get(0));
		//BFS(gr,0);
		//DFS(gr);
//		
		int[][] graph = 
				{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		
		//dijkstras(graph,0);
	}

	
	/***
	 * Dijkstra's Algorithm for shortest path from source to all vertices
	 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/ 
	 * */
	int[] dist = new int[V];
	boolean[] spt = new boolean[V]; // shortest path tree
	public void dijkstras(int[][] gr, int src) {
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}
		dist[src] = 0;
		for(int count=0;count<V-1;count++) {
			int u = minDistVertex(dist,spt);
			spt[u] = true;
			for(int v=0;v<V;v++) {
				if(!spt[v] && (gr[u][v] != 0)  && dist[u]+gr[u][v] <= dist[v])
					dist[v] = dist[u] + gr[u][v];
			}
		}
		printDistance(dist);
	}
	
	
	private void printDistance(int[] dist) {
		for(int i = 0; i< V;i++) {
			System.out.println("distance of " + i + "      " + dist[i]);
		}
	}


	private int minDistVertex(int[] dist, boolean[] spt) {
		int min = Integer.MAX_VALUE; int minVertex = 1;
		for(int i=0;i<V;i++) {
			if(!spt[i] && dist[i] < min) {
				min = dist[i];
				minVertex = i;
			}
		}
		return minVertex;
	}


	/**
	 *                  (0)------------------------(1)
	 *                    |	|                           |
	 *                     |		|                           |  
	 *                      | 		|                            |
	 *                    -  |-   -		-	|  -     -       -     (2)
	 *                 -        |  			   |                            
	 *              (4)---------(5)            (3)       
	 *              
	 *              
	 * */
	
	int gr[][] = { 
			{ 0, 1, 0, 1, 0, 1 }, 
			{ 1, 0, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0 }
			};
	String[] color = new String[gr.length];
	int[] parent = new int[gr.length];
	int[] discoveryTIme = new int[gr.length];
	int[] finishingTime = new int[gr.length];
	int time = 0;
	private void DFS(int[][] gr) {
		for(int i = 0; i < color .length; ++i)
			color[i] = "white";
//		for(int i = 0; i < gr[0].length; ++i) 			
//			if(i < color.length && color[i].equalsIgnoreCase("white")) 
				dfsVisit(gr,0);
	}

	private void dfsVisit(int[][] gr, int u) {
		// TODO Auto-generated method stub
		color[u] = "gray";
		//System.out.println("color of " + u +" is gray" );
		time++;
		discoveryTIme[u] = time;
		System.out.println("discoveryTIme of " + u +" is "  + time);
		int[] neighbours = new int[gr.length];
		neighbours = getNeighbours(gr, u);
		for(int i = 0;i<neighbours.length;++i) {
			if(neighbours[i] != MAX_VAL && color[neighbours[i]].equalsIgnoreCase("white")) {
				parent[neighbours[i]] = u;
				dfsVisit(gr, neighbours[i]);
			}			
		}
		color[u] = "Black";
		//System.out.println("color of " + u +" is black" );
		finishingTime[u] = time++;
		System.out.println("finishingTIme of " + u +" is "  + time);
	}
	

	public static final int MAX_VAL = 999;

	private ArrayList<Node> createGraph(int[][] gr) {
		// TODO Auto-generated method stub

		ArrayList<Node> a = new ArrayList<Node>();

		a.add(new Node(0));
		a.add(new Node(1));
		a.add(new Node(2));
		a.add(new Node(3));
		a.add(new Node(4));
		a.add(new Node(5));

		int[] list;
		Node u;

		for (int i = 0; i < a.size(); ++i) {
			try {
				u = a.get(i);
				list = getNeighbours(gr, u.data); // get Neighbours of u
				// printArray(list);
				BuildChain(u, list);
				printList(u, u.adjList);
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		return a;
	}

	public void printList(Node u, List l) {
		while (l != null && l.data != MAX_VAL) {
			System.out.print(u.data + "::" + l.data + "-> " + "   ");
			l = l.next;
		}
		System.out.println();
	}

	private void BuildChain(Node u, int[] list) {
		// TODO Auto-generated method stub

		List head = null;
		for (int j = 0; j < list.length; ++j) {
			if (list[j] != MAX_VAL) {
				List node = new List();
				node.data = list[j];

				if (u.adjList == null)
					u.adjList = node;
				else {
					head = u.adjList;
					while (head.next != null)
						head = head.next;
					head.next = node;
				}
			}
		}
	}

	private int[] getNeighbours(int[][] gr, int u) {
		// TODO Auto-generated method stub

		int[] l = new int[gr.length];
		for (int i = 0; i < l.length; ++i)
			l[i] = MAX_VAL;
		for (int i = 0; i < gr[0].length; ++i) {

			if (gr[u][i] == 1) {
				// System.out.println("["+u+"]" + "[" +i +"]" + " : " + "1");
				// System.out.println( u + " - " + i);
				l[i] = i;
			}
		}
		return l;
	}

	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; ++i) {
			if (a[i] != MAX_VAL)
				System.out.print(a[i] + "->");
		}
		System.out.println();
	}

	Node[] Q = new Node[10];
	int[] q = new int[10];
	public static int f = 0;
	public static int r = -1;

	public void enqueue(Node u) {
		if (isQFull()) {
			System.out.println("Q is Full, cannot Enqueue");
			return;
		}
		Q[++r] = u;
	}

	private boolean isQFull() {
		// TODO Auto-generated method stub
		if (r >= Q.length)
			return true;
		return false;
	}

	public Node dequeue() {
		if (isQEmpty()) {
			System.out.println("Q is Empty");
			return null;
		}
		Node temp = Q[f++];
		return temp;
	}

	private boolean isQEmpty() {
		// TODO Auto-generated method stub
		if (f > r)
			return true;
		return false;
	}

	/***
	 * BFS - Breadth First Search using Adjacency List 
	 * */
	public void BFS(ArrayList<Node> node, Node u) {		

		Node[] neighbours = new Node[node.size()];
		enqueue(u);
		while (!isQEmpty()) {
			u = dequeue();
			u.color = "Gray";
			neighbours = getNeighbours(node, u);
			for (int s = 0; neighbours != null && s < neighbours.length; ++s) {
				if (neighbours[s] != null
						&& neighbours[s].color.equalsIgnoreCase("white")) {

					neighbours[s].distance = u.distance + 1;
					neighbours[s].parent = u;
					neighbours[s].color = "Gray";
					enqueue(neighbours[s]);
				}
			}

			u.color = "Black";
			System.out.println("distance of " + u.data + " is " + u.distance);
		}
	}
	
	/***
	 * BFS using Adjacency matrix
	 * */
	 public void BFS(int[][] gr, int u) {
		 String[] color = new String[gr.length];
		 int[] dist = new int[gr.length];
		 int[] parent = new int[gr.length];
		 int[] neighbours = new int[gr.length];
		 
		 for(int i = 0; i< color.length;++i)
			 color[i] = "white";
		 
		 for(int i = 0; i< dist.length;++i)
			 dist[i] = 0;
		 
		 enqueue(u);		 
		 color[u] = "gray";
		 parent[u] = 0;
		 
		 while(! isQEmpty()) {
			 u = dequeue1();
			 if(u != -1) {
				 neighbours = getNeighbours(gr, u); 
				 for(int i = 0;i < neighbours.length; ++i) {
					 
					 if(neighbours[i] != MAX_VAL && color[neighbours[i]].equalsIgnoreCase("white")) {
						color[neighbours[i]] = "gray";
						dist[neighbours[i]] = dist[u] + 1;
						parent[neighbours[i]] = u;
						enqueue(neighbours[i]);
					 }
				 }
			 }
			 color[u] = "Black";
			//System.out.println("distance of " + u  + " is " + dist[u] );
		 }		
		 for(int i = 0; i< parent.length;++i) 
			 System.out.println("Parent of " + i + " is " + parent[i]);
		 
		 System.out.println();
		 for(int i = 0; i< dist.length;++i) 
			 System.out.println("Distane from " + 0 + " to " + i + " is "+ dist[i]);
	 }
	private void enqueue(int u) {
		// TODO Auto-generated method stub
		if (isQFull()) {
			System.out.println("Q is Full, cannot Enqueue");
			return;
		}		
		q[++r] = u;
	}
	private int dequeue1() {
		if (isQFull()) {
			System.out.println("Q is Full, cannot Enqueue");
			return -1;
		}
		int temp = q[f++];
		return temp;
	}

	private void printList(Node u, Node[] neighbours) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < neighbours.length && neighbours[i] != null) {
			System.out.print("neigh " + u.data + "::" + neighbours[i].data
					+ "-> " + "   ");
			++i;
		}
		System.out.println();
	}

/*	private Node[] getNeighbours(ArrayList<Node> node, Node u) {
		// TODO Auto-generated method stub

		Node[] l = new Node[node.size()];
		List head = u.adjList;
		Node newNode;
		int i = 0;
		while (head != null) {
			*//***
			 * Traverse the ArrayList and match the data in the ArrayList 
			 * and the Link List of a Given Node 
			 * *//*
			for (int j = 0; j < node.size(); ++j) {
				newNode = node.get(j);
				if (newNode.data == head.data) {
					l[i] = newNode;
					break;
				}
			}
			head = head.next;
			++i;
		}
		return l;
	}
*/
	private Node[] getNeighbours(ArrayList<Node> node, Node u) {
		// TODO Auto-generated method stub

		Node[] l = new Node[node.size()];
		List head = u.adjList;
		int i = 0;
		if(head == null)
			return null;
		else {
			while (head != null) {
				Node newNode = new Node(head.data);
				l[i] = newNode;
				head = head.next;
				i++;			
			}
			return l;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graphs();
	}
	
	// 02-July-16 : 10:14AM Sat
	public void BFS1(ArrayList<Node> nodes ,Node s) {
		enqueue(s);
		while(!isQEmpty()) {
			Node u = dequeue();
			u.color = "gray"; 
			Node[] neighbours = getNeighbours(nodes, u);
			for(int i=0; neighbours!=null && i < neighbours.length;i++) {
				if(neighbours[i] != null && neighbours[i].color.equalsIgnoreCase("white")) {
					neighbours[i].color = "gray";
					neighbours[i].distance = u.distance+1;
					neighbours[i].parent = u;
					enqueue(neighbours[i]);
				}
			}
			u.color = "black";
			System.out.println("distance of " + u.data + " is " + u.distance);
 		}
	}

}
