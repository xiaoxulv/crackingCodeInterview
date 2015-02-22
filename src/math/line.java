package math;

public class line{
	static double epsilon = 0.001;
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
	
	public line(point p1, point p2){
		if(Math.abs(p1.x - p2.x) < epsilon){
			slope = (p1.y-p2.y)/(p1.x-p2.x);
			yintersect = p1.y - slope*p1.x;
		}else{
			infSlope = true;
			xintersect = p1.x;
		}
	}
	
	public boolean isEqual(double d1, double d2){
		return Math.abs(d1-d2) < epsilon;
	}
	public static double toNear(double d){
		int r = (int) (d/epsilon);
		return ((double)r) * epsilon;
	}
	public boolean isEqual(line l) {
		if((l.slope == slope) && (l.yintersect == yintersect) &&
				(l.infSlope == infSlope) && (l.xintersect == xintersect))
			return true;
		return false;
	}
	public String toString(){
		if(!infSlope)
			return " y =  " + slope + "x + "+ yintersect;
		return "x = " + xintersect;
		}

}