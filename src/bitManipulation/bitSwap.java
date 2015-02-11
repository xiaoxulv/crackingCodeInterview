package bitManipulation;

public class bitSwap {
	public static int SwapBits(int a, int b){
		int count = 0;
		for(int c = a^b; c != 0; c = c>>1)
			// or c = c&(c-1) to clear least significant bit
			count += c&1;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SwapBits(15,13));
		System.out.println(SwapBits(0,13));
	}

}
