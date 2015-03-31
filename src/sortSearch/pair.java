package sortSearch;

public class pair implements Comparable {
	private int Ht;
	private int Wt;

	public pair(int h, int w) {
		Ht = h;
		Wt = w;
	}

	public String toString() {
		return "(" + Ht + ", " + Wt + ")";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		pair second = (pair) o;
		if (this.Ht != second.Ht) 
			return ((Integer) this.Ht).compareTo(second.Ht);
		else 
			return ((Integer) this.Wt).compareTo(second.Wt);
	}


	public boolean isBefore(pair other) {
		if (this.Ht < other.Ht && this.Wt < other.Wt) 
			return true;
		else 
			return false;
	}
}
