package stackQueue;

import java.util.Stack;

public class hanoi{
	//1~n,0,0
	//n,1~n-1,0
	//0,1~n-1,n
	//0,0,1~n
	public static void Hanoi(int n, char src, char bri, char dst){
		if(n == 1)
			System.out.println("Move " + n + " from " + src + " to " + dst);
		else{
			Hanoi(n - 1, src, dst, bri);
			System.out.println("Move " + n + " from " + src + " to " + dst);
			Hanoi(n - 1, bri, src, dst);
		}
	}

	public class Tower{
		private Stack<Integer> disks;
		private int index;

		public Tower(int i){
			disks = new Stack<Integer>();
			index = i;
		}

		public int index(){
			return index;
		}

		public void add(int d){
			if(!disks.isEmpty() && disks.peek() <= d)
				System.out.println("Error placing disk " + d);
			else
				disks.push(d);
		}

		public void moveTopTo(Tower t){
			int top = disks.pop();
			t.add(top);
			System.out.println("Move disk " + top + " from " + index() + " to "
					+ t.index());
		}

		public void moveDisks(int n, Tower destination, Tower buffer){
			if(n <= 0)
				return;
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
		//1~n,0,0
		//n,1~n-1,0
		//0,1~n-1,n
		//0,0,1~n
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Hanoi(3, 'a', 'b', 'c');

		hanoi h = new hanoi();
		int n = 3;
		Tower[] towers = new Tower[n];
		for(int i = 0; i < towers.length; i++)
			towers[i] = h.new Tower(i);
		for(int i = n - 1; i >= 0; i--)
			towers[0].add(i);
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}

