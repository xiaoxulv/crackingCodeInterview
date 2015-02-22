package math;


import java.util.LinkedList;
import java.util.Queue;

public class findKth {
	public static int findk(int k){
		int res = 0;
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		q3.add(1);
		for(int i = 0; i <= k; i++){
			int v3 = Integer.MAX_VALUE, v5 = Integer.MAX_VALUE,
					v7 = Integer.MAX_VALUE;
			if(!q3.isEmpty()) v3 = q3.peek();
			if(!q5.isEmpty()) v5 = q3.peek();
			if(!q3.isEmpty()) v7 = q3.peek();
			res = Math.min(v3, Math.min(v5, v7));
			if(res == v3){
				q3.remove();
				q3.add(3*v3);
				q5.add(5*v3);
				q7.add(7*v3);
			}else if(res == v5){
				q5.remove();
				q5.add(5*v3);
				q7.add(7*v3);
			}else if(res == v7){
				q5.remove();
				q7.add(7*v3);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findk(3));
	}

}
