package string;

import java.util.Arrays;
import java.util.HashMap;

public class ifPermutation {
	//use char array
	public static boolean permutation (String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		char []c1 = s1.toCharArray();
		char []c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}
	//use hashmap
	public static boolean permutation2(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length();i++){
			int v = 1;
			if(m1.containsKey(s1.charAt(i)))
				v += m1.get(s1.charAt(i)) ;
			m1.put(s1.charAt(i), v);
		}
		HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length();i++){
			int v = 1;
			if(m2.containsKey(s2.charAt(i)))
				v += m2.get(s2.charAt(i)) ;
			m2.put(s2.charAt(i), v);
		}
		if(m1.size() != m2.size())
			return false;
		for(char c : m1.keySet())
			if(!m2.containsKey(c) || m2.get(c)!= m1.get(c))
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sdfsd";
		String s2 = "fdsds";
		System.out.println(permutation(s1, s2));
		System.out.println(permutation2(s1, s2));
		
	}

}
