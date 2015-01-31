package stackQueue;

import java.util.Stack;

public class Minstack {
	stack s = new stack(10000);
	stack m = new stack(10000);
	public int min(){
		if(m.isEmpty())
			return Integer.MAX_VALUE;
		else
			return m.peek();
	}
	public void push(int val){
		s.push(val);
		if(val <= min())
			m.push(val);
	}
	public void pop(){
		if(s.peek() == min())
			m.pop();
		s.pop();
	}
	public int peek(){
		return s.peek();
	}
	public boolean isEmpty(){
		return s.isEmpty();
	}
	// common stack here
	public class stack{
		int s[];
		int p;
		public stack(int size){
			s = new int [size];
			p = -1;
		}
		public void push(int val){
			p++;
			s[p] = val;
		}
		public void pop(){
			p--;
		}
		public int peek(){
			return s[p];
		}
		public boolean isEmpty(){
			return p == -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minstack m = new Minstack();
		m.push(0);
		m.push(1);
		System.out.println(m.min());
		System.out.println(m.peek());
		m.push(0);
		System.out.println(m.min());
		System.out.println(m.peek());
		m.pop();
		System.out.println(m.min());
		System.out.println(m.peek());
		
	}

}
