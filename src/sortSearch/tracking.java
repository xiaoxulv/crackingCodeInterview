package sortSearch;

public class tracking {
	public static RankNode root = null;

	public static void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
