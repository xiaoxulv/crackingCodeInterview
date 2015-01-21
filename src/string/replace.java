package string;

public class replace {
	//in place as char array
	public static void replaceChar(char []ch, int len){
		int count = 0;
		for(int i = 0; i < len; i++){
			if(ch[i] == ' ')
				count++;
		}
		count = count * 2 + len;
		//System.out.println(count);
		for(int i = len-1; i >= 0; i--){
			if(ch[i] == ' '){
				ch[count-1] = '0';
				ch[count-2] = '2';
				ch[count-3] = '%';
				count -= 3;
			}
			else{
				ch[count-1] = ch[i];
				count--;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "my name is lxx                    ";
		char []ch = s.toCharArray();
		replaceChar(ch, 14);
		System.out.println(ch);

	}

}
