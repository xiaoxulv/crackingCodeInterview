package sortSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class sort {
	public void AnagramSort(String[] strs){
		Map<String, LinkedList<String>> m = new HashMap<String, LinkedList<String>>();
		for(String s : strs){
			String key = sortChars(s);
			if(!m.containsKey(key))
				m.put(key, new LinkedList<String>());
			LinkedList<String> l = m.get(key);
			l.add(s);
		}
		int i = 0;
		for(String key : m.keySet()){
			LinkedList<String> l = m.get(key);
			for(String s : l){
				strs[i] = s;
				i++;
			}
		}
	}
	public static String sortChars(String s){
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
//	public class AnagramComparator implements Comparator<String>{
//		public String sortChars(String s){
//			char[] ch = s.toCharArray();
//			Arrays.sort(ch);
//			return new String(ch);
//		}
//		@Override
//		public int compare(String s1, String s2) {
//			// TODO Auto-generated method stub
//			return sortChars(s1).compareTo(sortChars(s2));
//		}
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort s = new sort();
		String[] strs = {"abc","dfa","cba","fda"};
		s.AnagramSort(strs);
		for(String str : strs)
			System.out.println(str);;
		
	}

}
