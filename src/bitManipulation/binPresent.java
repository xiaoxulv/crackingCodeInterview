package bitManipulation;

public class binPresent {
	public static String bin(double num){
		if(num >= 1 || num <= 0) return "Invalid";
		String res = ".";
		double sub = 0.5;
		int i = 0;
		while(i < 32&&num > 0){
			if(num >= sub){
				res += "1";
				num = num - sub;
			}
			else
				res += "0";
			sub /= 2;
			i++;
		}

		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bin(0.875));
	}

}
