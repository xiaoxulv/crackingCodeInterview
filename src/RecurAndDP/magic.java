package RecurAndDP;

public class magic {
	public int findMagic(int[] n) {
		//return find(n, 0, n.length-1);
		return find2(n, 0, n.length-1);
	}

	private int find(int[]n, int start, int end){
		if(start > end||start < 0||end >= n.length)
			return -1;
		int mid = start + (end-start)/2;
		if(n[mid] == mid)
			return mid;
		else if(n[mid] > mid)
			return find(n, start, mid-1);
		else
			return find(n, mid+1, end);
	}
	
	private int find2(int[]n, int start, int end){
		if(start > end||start < 0||end >= n.length)
			return -1;
		int mid = start + (end-start)/2;
		if(n[mid] == mid)
			return mid;
		int lm = Math.min(n[mid], mid-1);
		int l = find2(n, start, lm);
		if(l > 0) return l;
		int rm = Math.max(n[mid], mid+1);
		int r = find2(n, rm, end);
		
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		int n2[] = {-10,-5,2,2,2,3,4,7,9,12,13};
		magic m = new magic();
		System.out.println(m.findMagic(n));
		System.out.println(m.findMagic(n2));
	}

}
