package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bestline {
	public line findBest(point[] points){
		line bestline = null;
		int bestcount = 0;
		Map<Double, List<line>> lineBySlope = new HashMap<Double, List<line>>();
		for(int i = 0; i < points.length; i++){
			for(int j = i+1; j < points.length; j++){
				line l = new line(points[i], points[j]);
				insertLine(lineBySlope, l);
				int countE = countEqu(lineBySlope, l);
				if(countE > bestcount){
					bestcount = countE;
					bestline = l;
				}
			}
		}
		return bestline;
	}
	public int countEqu(Map<Double, List<line>> lineBySlope, line l) {
		double key = line.toNear(l.slope);
		double eps = line.epsilon;
		int count = count(lineBySlope.get(key),l) + 
				count(lineBySlope.get(key + eps),l) + 
					count(lineBySlope.get(key - eps),l);
		return count;
	}
	public int count(List<line> lines, line l){
		if(lines == null)
			return 0;
		int count = 0;
		for(line li : lines){
			if(li.isEqual(l))
				count++;
		}
		return count;
	}
	public void insertLine(Map<Double, List<line>> lineBySlope, line l) {
		List<line> lines = null;
		double key = line.toNear(l.slope);
		if(!lineBySlope.containsKey(key)){
			lines = new ArrayList<line>();
			lineBySlope.put(key, lines);
		}else{
			lines = lineBySlope.get(key);
		}
		lines.add(l);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hehehehehehe
	}

}
