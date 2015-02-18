package math;

public class calc {
	// util functions here 
	public static int abs(int n){
		if(n < 0) return negate(n);
		return n;
	}
	public static int negate(int n){
		int res = 0;
		int unit = 1;
		if(n > 0) unit = -1;
		while(n != 0){
			res += unit;
			n += unit;
		}
		return res;
	}
	//calculation here
	public static int substract(int a, int b){
		return a + negate(b);
	}
	public static int multiply(int a, int b){
		if(abs(a) < abs(b))
			return multiply(b, a);
		int res = 0;
		for(int i = abs(b); i > 0; i--)
			res +=a;
		if(b < 0)
			return negate(res);
		return res;
	}
	public static int divide(int a, int b){
		if(b == 0)
			return Integer.MAX_VALUE;
		int aa = abs(a);
		int bb = abs(b);
		int res = 0;
		int tmp = 0;
		while(bb + tmp <= aa){
			tmp += bb;
			res++;
		}
		if((a>0&&b>0)||(a<0&&b<0))
			return res;
		else
			return negate(res);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(abs(-3));
		System.out.println(negate(-2));
		System.out.println(substract(2,-3));
		System.out.println(multiply(-2,3));
		System.out.println(divide(3,2));
		
	}

}
