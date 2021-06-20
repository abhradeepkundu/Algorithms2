
public class Qusing2Stacks {
	
	public static final int STACKSIZE = 6;
	
	
	public Qusing2Stacks() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		stack s1 = new stack();
		stack s2 = new stack();
		//int i = s1.stack.length-1;
		int i = 15;
		/***
		 * inserting in the queue
		 * */
		while( i > 0 ) {
			Enqueue(s1,i);
			--i;
		}
		
		displayQueue(s1);
		int j = 0;
		while( j < s2.stack.length ) {
			/***
			 * Removing the elements from the queue
			 * */
			int result = Dequeue(s1, s2);
			System.out.println("The popped element is : " + result);
			j++;
		}
	}
	
	public static class stack {
		int top=-1;
		int[] stack = new int[STACKSIZE];
	}
	
	public void Enqueue(stack s,int val) {
		Push(s,val);
	}
	public boolean isStackFull(stack s) {
		if(s.top < (STACKSIZE -1))
			return false;
		return true;
	}
	
	public boolean isStackEmpty(stack s) {
		if(s.top < 0)
			return true;
		return false;
	}
	public void Push(stack s,int val) {
		if(isStackFull(s)) {
			System.out.println("Stack1 Overflow !!");
			return;
		}
		System.out.println("pushing : " + val);
		s.stack[++s.top]= val;
	}
	public int Dequeue(stack s1,stack s2) {
		return Pop(s1,s2);
	}
	public int Pop(stack s1,stack s2) {
		int temp;
		if(isStackEmpty(s1) && isStackEmpty(s2)) {
			System.out.println("Both the stacks are empty || No Action");
			return -1;
		}
		if(isStackEmpty(s2)) {
			while(!isStackEmpty(s1)) {
				Push(s2,s1.stack[s1.top--]);
			}
		}
		if(s2.top >= 0) {
			temp = s2.stack[s2.top--];
			return temp;
		}
		return -1;
	}
	
	
	private void displayQueue(stack s) {
		// TODO Auto-generated method stub
		for(int i=0;i < s.stack.length;++i)
			System.out.println(" i => " + i + " : " + s.stack[i]);
	}


	public void implementStack() {
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Qusing2Stacks();
	}

}
