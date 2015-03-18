package RecurAndDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class path {

	public class Point{
		int x;
		int y;
		public Point(int m, int n){
			x = m;
			y = n;
		}
	}
	public boolean isAva(int x, int y){
		//something here to set the off limit
		return true;
	}
	public List<Point> getPath(Point p){
		ArrayList<Point> l = new ArrayList<Point>();
		HashMap<Point, Boolean> c = new HashMap<Point, Boolean>();
		helper(p,l,c);
		if(p.x == 0 && p.y == 0) l.add(p);
		return l;
		// if l is empty, then no path found
	}
	private boolean helper(Point p, ArrayList<Point> l, HashMap<Point, Boolean> cache){
		if(cache.containsKey(p))
			return cache.get(p);
		boolean flag = false;
		if(p.x > 0&&isAva(p.x-1, p.y)){
			Point m = new Point(p.x-1,p.y);
			flag = helper(m, l, cache);
		}
		if(p.y > 0&&isAva(p.x, p.y-1)){
			Point m = new Point(p.x, p.y-1);
			flag = helper(m, l, cache);
		}
		if(flag) l.add(p);
		cache.put(p, flag);
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
