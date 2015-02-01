package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	Queue<Integer> q = new LinkedList<Integer>();
	public void push(int val){
		q.add(val);
	}
	public int pop(){
		int s = q.size();
		while(s > 1){
			q.add(q.remove());
			s--;
		}
		return q.remove();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueToStack s = new QueueToStack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
	}

}
