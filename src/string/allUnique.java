package string;

public class allUnique {
	//if character ASCII
	public static boolean allUniqueChar(String s){
		boolean []flag = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			int ch = s.charAt(i);
			if(flag[ch])
				return false;
			flag[ch] = true;
		}
		return true;
	}
	//bit manipulation, 256 = 8 int
	public static boolean allUniqueCharBit(String s){
		int []flag = new int[8];
		for(int i = 0; i < s.length(); i++){
			int v = s.charAt(i);
	        int idx = v/32, shift = v%32;
	        if((flag[idx] & (1 << shift)) > 0)
	        	return false;
	        flag[idx] |= (1 << shift);
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a!bs";
		System.out.println(allUniqueChar(s));
		System.out.println(allUniqueCharBit(s));
	}

}
