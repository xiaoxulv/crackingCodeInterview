package bitManipulation;

public class SwapBits {
	public static int swap(int n){
		return ((n & 0xaaaaaaaa) >>1) | ((n & 0x55555555) <<1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(swap(4));
		System.out.println(swap(6));
	}

}
