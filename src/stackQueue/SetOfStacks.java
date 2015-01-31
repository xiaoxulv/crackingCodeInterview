package stackQueue;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks{
	List<stack> stacks = new ArrayList<stack>();
	int capacity;

	public SetOfStacks(int capacity){
		this.capacity = capacity;
	}
	public stack getLastStack(){
		if(stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	public void push(int v){
		stack last = getLastStack();
		if(last != null && !last.isFull()){
			last.push(v);
		} 
		else{
			stack stack = new stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	public int pop(){
		stack last = getLastStack();
		int v = last.pop();
		if(last.size == 0)
			stacks.remove(stacks.size() - 1);
		return v;
	}
	public boolean isEmpty(){
		stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	public int popAt(int index){
		return leftShift(index, true);
	}
	public int leftShift(int index, boolean removeTop){
		stack stack = stacks.get(index);
		int removed_item;
		if(removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		if(stack.isEmpty()){
			stacks.remove(index);
		} 
		else if(stacks.size() > index + 1){
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}

	public class stack{
		private int capacity;
		public Node top;
		public Node bottom;
		public int size;

		public stack(int capacity){
			size = 0;
			this.capacity = capacity;
		}

		public boolean isFull(){
			return capacity == size;
		}
		public void join(Node above, Node below){
			if(below != null)
				below.above = above;
			if(above != null)
				above.below = below;
		}
		public boolean push(int v){
			if(size >= capacity)
				return false;
			size++;
			Node n = new Node(v);
			if(size == 1)
				bottom = n;
			join(n, top);
			top = n;
			return true;
		}
		public int pop(){
			Node t = top;
			top = top.below;
			size--;
			return t.value;
		}
		public boolean isEmpty(){
			return size == 0;
		}
		public int removeBottom(){
			Node b = bottom;
			bottom = bottom.above;

			if(bottom != null)
				bottom.below = null;

			size--;
			return b.value;
		}
	}
	
	
	
	public class Node{
		public Node below;
		public Node above;
		public int value;
		public Node(int v){
			value = v;
		}
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SetOfStacks s = new SetOfStacks(2);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.popAt(2);
		System.out.println(s.pop());
	}

}
