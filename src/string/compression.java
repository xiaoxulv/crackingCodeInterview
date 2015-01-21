package string;

public class compression {
	public static String compress(String s){
		if(s.length() == 0||s.length() == 1)
			return s;
		String newStr = "";
		int i = 0;
		//boolean f = false;
		while(i < s.length()){
			newStr += s.charAt(i);
			int count = 1;
			while(i+1 < s.length()&&s.charAt(i+1) == s.charAt(i)){
				count++;
				i++;
				//if(!f)
					//f = true;
			}
			newStr += count;
			i++;
		}
		//if(!f)
		if(s.length() <= newStr.length())
			return s;
		return newStr;
	}
/*	public static String betterCompress(String s){
		int size = countCompression(s);
		if(size >= s.length())
			return s;
		char[] array = new char[size];
		int index =0;
		char last = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) { 
				count++;
			}else{
				index = setChar(array, last, index, count); 
				last = s.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	static int setChar(char[] array, char c, int index, int count) { 
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for(char x:cnt){  
			array[index] = x;
			index++;
		}
		return index;
	}
	static int countCompression(String str){
		if (str == null | str.isEmpty()) return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			}else{
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length(); 
				count = 1;
			} 
		}
				size += 1 + String.valueOf(count).length();
				return size;
	}
*/	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adjt";
		System.out.println(compress(s));
		//System.out.println(betterCompress(s));
		
	}

}
