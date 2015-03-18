package RecurAndDP;

public class climb {
	public static int climbways(int n){
		if(n < 0) return 0;
		int count[] = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		for(int i = 3; i < n+1; i++)
			count[i] = count[i-1]+count[i-2]+count[i-3];
		return count[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbways(5));
	}

}
