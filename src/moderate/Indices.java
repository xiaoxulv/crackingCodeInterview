package moderate;

public class Indices {
	public static int leftEnd(int[] n){
		for(int i = 1; i < n.length; i++)
			if(n[i] < n[i-1]) 
				return i-1;
		//already sorted
		return n.length-1;
	}
	public static int rightStart(int[] n){
		for(int i = n.length-2; i > 0; i--)
			if(n[i] > n[i+1])
				return i+1;
		//already sorted
		return 0;
	}
	public static int leftExpand(int[] n, int min, int le){
		for(int i = le-1; i >= 0; i--){
			if(n[i] <= n[min]) 
				return i+1;
		}
		return 0;
	}
	public static int rightExpand(int[] n, int max, int rs){
		for(int i = rs; i < n.length; i++){
			if(n[i] >= n[max])
				return i-1;
		}
		return n.length-1;
	}
	public Result findIndices(int[] n){
		int le = leftEnd(n);
		int rs = rightStart(n);
		//find min max in the middle part
		int min = le+1;
		if(min == n.length) return null;//already sorted
		int max = rs-1;
		for(int i = le; i <= rs; i++){
			if(n[i] > n[max])
				max = i;
			if(n[i] < n[min])
				min = i;
		}
		
		Result res = new Result();
		res.n = rightExpand(n, max, rs);
		res.m = leftExpand(n, min, le);
		return res;
	}
	public class Result{
		int n;
		int m;
		public String toString(){
			return n + "; " + m;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Indices i = new Indices();
		int[] n = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		System.out.println(i.findIndices(n));
	}

}
