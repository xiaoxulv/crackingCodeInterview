package sortSearch;

public class findMatrix {
	public coord find(int[][] m, int target){
		int i = 0;
		int j = m[0].length-1;
		while(i < m.length && j >= 0){
			if(m[i][j] == target)
				return new coord(i,j);
			else if(m[i][j] < target)
				i++;
			else
				j--;
		}
		return new coord(-1,-1);
	}
	public class coord{
		int x;
		int y;
		public coord(int i, int j){
			x = i;
			y = j;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMatrix f = new findMatrix();
		int[][] m = {{1,2,3},{2,3,4},{4,6,8}};
		System.out.println(f.find(m,6).x);
		System.out.println(f.find(m,6).y);
		
		
	}

}
