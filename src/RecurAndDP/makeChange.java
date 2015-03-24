package RecurAndDP;

public class makeChange {
	public static int make(int change[], int m, int sum) {
		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;
		if (sum >= 1 && m <= 0)
			return 0;
		return make(change, m - 1, sum) + make(change, m, sum - change[m - 1]);
	}

	public int makechange(int sum, int denom) {
		int next = 0;
		if (denom == 25)
			next = 10;
		if (denom == 10)
			next = 5;
		if (denom == 5)
			next = 1;
		if (denom == 1)
			return 1;
		int res = 0;
		for (int i = 0; i * denom <= sum; i++)
			res += makechange(sum - i * denom, next);
		return res;
	}

	public static int count(int S[], int m, int n) {
		int i, j, x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner
		// using
		// the base case 0 value case (n = 0)
		int table[][] = new int[n + 1][m];

		// Fill the enteries for 0 value case (n = 0)
		for (i = 0; i < m; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n + 1; i++) {
			for (j = 0; j < m; j++) {
				// Count of solutions including S[j]
				x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;
				
				// Count of solutions excluding S[j]
				y = (j >= 1) ? table[i][j - 1] : 0;
				// total count
				table[i][j] = x + y;
				//System.out.print(table[i][j]);
			}
			//System.out.println();
		}

		return table[n][m - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeChange mc = new makeChange();
		int s[] = { 1, 5, 10, 25 };
		//int s[] = {1,2,3,4};
		//System.out.println(make(s, s.length, 5));
		System.out.println(mc.makechange(100, 25));
		
		System.out.println(count(s,4,100));
	}

}
