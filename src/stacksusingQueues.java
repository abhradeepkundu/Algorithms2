


public class stacksusingQueues {

	public stacksusingQueues() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public static final int QUEUESIZE = 10;
	private void run() {
		// TODO Auto-generated method stub
		Queue q1 = new Queue();
		Queue q2 = new Queue();
		
		push(q1,1);
		push(q1,2);
		push(q1,3);
		push(q1,4);
		push(q1,5);
		push(q1,6);
		push(q1,7);
		push(q1,8);
		push(q1,9);
		push(q1,10);
		
		
		displayStack(q1);
		
		int x = Pop(q1,q2);
		int x1 = Pop(q1,q2);
		int x3 = Pop(q1,q2);
		
		System.out.println("The popped element is " + x1);
	}
	
	public static class Queue {
		int f = 0;
		int r = -1;
		int[] Q = new int[QUEUESIZE];
	}
	public void push(Queue q, int val) {
		Enqueue(q,val);
	}
	
	private void Enqueue(Queue q, int val) {
		// TODO Auto-generated method stub
		if(isQfull(q)) {
			System.out.println("Q full");
			return;
		}
		q.Q[++q.r] = val;
	}
	public int Pop(Queue q1,Queue q2){
		 return Dequeue(q1,q2);		
	}

	private int Dequeue(Queue q1, Queue q2) {
		// TODO Auto-generated method stub
		int temp = -1;
		/*if(isQEmpty(q1) && isQEmpty(q2)) {
			System.out.println("Both Q's are Empty !! Cannot Dequeue");
			return -1;
		}*/
		while(q1.f <= q1.r) {
			  temp = q1.Q[q1.f++];
			 Enqueue(q2,temp);
		}
		/*if(!isQEmpty(q1))
			temp = q1.Q[q1.r];*/
		
		// swap Q's
		Queue tempQ = q1;
		q1 = q2;
		q2=tempQ;
		return temp;
	}

	private boolean isQfull(Queue q) {
		// TODO Auto-generated method stub
		if(q.r >= q.Q.length-1) {
			System.out.println(" Q is full");
			return true;
		}
		return false;
	}

	private boolean isQEmpty(Queue q) {
		// TODO Auto-generated method stub
		if(q.f >= q.r) {
			System.out.println("Q empty");
			//q.f =0; q.r = -1;
			return true;
		}			
		return false;
	}
	
	private void displayStack(Queue s) {
		// TODO Auto-generated method stub
		for(int i=0;i < s.Q.length;++i)
			System.out.print(s.Q[i] + " ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  stacksusingQueues();
	}
}
