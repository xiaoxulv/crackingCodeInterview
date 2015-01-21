package string;

public class zero {
	public static void zeroSet(int[][] m){
		int r = m.length;
		int c = m[0].length;
		boolean[] row = new boolean[r];
		boolean[] col = new boolean[c];
		for(int i = 0; i < r ;i++)
			for(int j = 0; j < c; j++)
				if(m[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
		for(int i = 0; i < r ;i++)
			for(int j = 0; j < c; j++)
				if(row[i]||col[j])
					m[i][j] = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]m = {{1,2,0},{1,1,1}};
		zeroSet(m);
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j]);
			System.out.println();
		}
	}

}
