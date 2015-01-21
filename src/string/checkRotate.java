package string;

public class checkRotate {
	public static boolean check(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		return isSub(s1+s1,s2);
	}
	public static boolean isSub(String s1, String s2){
		if(s1.indexOf(s2) != -1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(check("apel","ppla"));
	}

}
