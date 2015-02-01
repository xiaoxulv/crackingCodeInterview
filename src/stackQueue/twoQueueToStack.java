package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class twoQueueToStack {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	public void push(int val){
		q1.add(val);
	}
	public int pop(){
		while(q1.size() != 1)
			q2.add(q1.remove());
		int res = q1.remove();
		//swap here
		q1.addAll(q2);
		q2.clear();
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twoQueueToStack s = new twoQueueToStack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
