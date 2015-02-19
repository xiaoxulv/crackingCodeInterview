package math;

public class LineHalf {
	public class point{
		double x;
		double y;
		public point(double n, double m){
			x = n;
			y = m;
		}
		public String toString(){
			return x + " " + y + " ";
		}
	}
	public class line{
		double yintersect;
		double slope;	
		boolean infSlope;
		double xintersect;
		public line(double y, double s){
			yintersect = y;
			slope = s;
			infSlope = false;
		}
		public line(double x){
			infSlope = true;
			xintersect = x;
		}
		public String toString(){
			if(!infSlope)
				return " y =  " + slope + "x + "+ yintersect;
			return "x = " + xintersect;
			}
		}
		
		public line half(point mid1, point mid2){
			//assume that their mid is different, or there will be
			//infinite lines that satisfy the requirement as long as
			// the line across the mid point
			if(mid1.x == mid2.x){
				return new line(mid1.x);
			}
			double s = (mid1.y - mid2.y)/(mid1.x - mid2.x);
			double yintersect = mid1.y - mid1.x * s;
			return new line(s, yintersect);
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hehe.....
	}

}
