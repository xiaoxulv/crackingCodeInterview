package RecurAndDP;

public class booleanEval {
	public static int f(String exp, boolean res, int s, int e){
		if(s == e){
			if(exp.charAt(s) == '1' && res)
				return 1;
			else if(exp.charAt(s) == '0' && !res)
				return 1;
			else
				return 0;
		}
		int c = 0;
		if(res){
			for (int i = s + 1; i <= e; i += 2) {
				char op = exp.charAt(i); 
				if (op == '&') {
					c += f(exp, true, s, i - 1) * f(exp, true, i + 1, e);
				} else if (op == '|' ) {
					c += f(exp, true, s, i - 1) * f(exp, false, i + 1, e);
					c += f(exp, false, s, i - 1)* f(exp, true, i +1, e);
					c += f(exp, true, s, i - 1) * f(exp, true, i + 1, e);
				} else if (op =='^') {
					c += f(exp, true, s, i - 1) * f(exp, false, i + 1, e); 
					c += f(exp, false, s, i - 1) * f(exp, true, i + 1, e);
				}
			}
		}
		else{
			for (int i = s + 1; i <= e; i += 2) {
				char op = exp.charAt(i); 
				if(op == '&') {
					c += f(exp, false, s, i - 1) * f(exp, true, i + 1, e); 
					c += f(exp, true, s,i -1)*f(exp, false, i +1,e);
					c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
				} else if (op == '|') {
					c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
				} else if (op == '^') {
					c += f(exp, true, s, i - 1) * f(exp, true, i +1, e); 
					c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1&1|0^1&1";
		System.out.println(f(s,true,0,s.length()-1));
	}

}
