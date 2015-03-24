package RecurAndDP;

public class makeChange {
	public static int make(int change[], int m, int sum){
		if(sum == 0) return 1;
		if(sum < 0) return 0;
		if(sum>=1 && m<=0)
			return 0;
		return make(change, m-1, sum) + make(change, m, sum-change[m-1]);
	}
	public int makechange(int sum, int denom){
		int next = 0;
		if(denom == 25) next = 10;
		if(denom == 10) next = 5;
		if(denom == 5) next = 1;
		if(denom == 1) return 1;
		int res = 0;
		for(int i = 0; i * denom <= sum; i++)
			res += makechange(sum-i*denom, next);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeChange mc = new makeChange();
		int s[] = {1,5,10,25};
		//int s[] = {1,2,3};
		System.out.println(make(s, s.length, 100));
		System.out.println(mc.makechange(100,25));
	}

}
