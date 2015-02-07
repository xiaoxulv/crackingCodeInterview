package bitManipulation;

public class insert {
	public static int insertBit(int n, int m, int i , int j){
		int one = ~0;
		int mask = one<<(j+1) | (1<<i)-1;
		return (n&mask) | m<<i;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// n = 10001 m = 111 i = 1 j = 3
		// res = 11111
		System.out.println(insertBit(17,15,1,3));
	}

}
