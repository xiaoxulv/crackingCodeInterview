package stackQueue;

import java.util.Stack;

public class sort {
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> res = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!res.isEmpty() && res.peek() > temp)
				s.push(res.pop());
			res.push(temp);	
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		Stack<Integer> s2 = sortStack(s);
		System.out.println(s2.pop());
		System.out.println(s2.pop());
		System.out.println(s2.pop());
		System.out.println(s2.pop());
	}

}
