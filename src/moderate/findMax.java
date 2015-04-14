package moderate;

public class findMax {

	public static int flip(int n){
		return 1^n;
	}
	public static int sign(int n){
		return flip((n>>31)&1);
	}
	//might overflow
	public static int max(int a, int b){
		int k = sign(a-b);
		int q = flip(k);
		return a*k+b*q;
	}
	//handle overflow
	public static int getMax(int a, int b){
		int t = sign(a)^sign(b);
		int k = t*sign(a) + flip(t)*sign(a-b);
		int q = flip(k);
		return a*k+b*q;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max(5,5));
		System.out.println(getMax(5,7));
		System.out.println(Integer.MAX_VALUE+15);
	}

}
