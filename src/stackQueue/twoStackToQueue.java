package stackQueue;

import java.util.Stack;

public class twoStackToQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
 	public void enqueue(int val){
 		s1.push(val);
 	}
 	public int dequeue(){
 		if(s2.isEmpty())
 			while(!s1.isEmpty())
 				s2.push(s1.pop());
 		return s2.pop();
 	}
 	public boolean isEmpty(){
 		return s1.isEmpty()&&s2.isEmpty();
 	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twoStackToQueue q = new twoStackToQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
