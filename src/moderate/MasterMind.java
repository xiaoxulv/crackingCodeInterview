package moderate;

public class MasterMind {
	public static int code(char c){
		switch(c){
		case'B':
			return 0;
		case'G':
			return 1;
		case'R':
			return 2;
		case'Y':
			return 3;
		default:
			return -1;
		}
	}
	public Result getRes(String real, String guess){
		if(real.length()!= guess.length())
				return null;
		Result res = new Result();
		int[] fre = new int[4];
		int[] hit = new int[4];
		for(int i = 0; i < 4; i++){
			int code = code(guess.charAt(i));
			if(guess.charAt(i) == real.charAt(i)){
				res.hits++;
				hit[code]++;
			}
			else{
				fre[code]++;
			}
		}
		for(int i = 0; i < 4; i++){
			fre[i] = fre[i]-hit[i];
		}
		for(int i = 0; i < 4; i++){
			if(fre[i]!=0)
				res.pseudoHits++;
		}
		return res;
	}
	public class Result{
		int hits = 0;
		int pseudoHits = 0;
		public String toString(){
			return hits + "; " + pseudoHits;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MasterMind m = new MasterMind();
		System.out.println(m.getRes("RGBY", "GGRR"));
	}

}
