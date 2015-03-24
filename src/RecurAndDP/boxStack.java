package RecurAndDP;

import java.util.ArrayList;
import java.util.HashMap;

public class boxStack {
	public ArrayList<Box> build(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> s){
		if(bottom != null && s.containsKey(bottom))
			return s.get(bottom);
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for(int i = 0; i < boxes.length; i++){
			if (boxes[i].isSmaller(bottom)){ 
				ArrayList<Box> new_stack =	build(boxes, boxes[i], s);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height){
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		if (max_stack == null) max_stack = new ArrayList<Box>();
		if (bottom != null) max_stack.add(0, bottom);
		s.put(bottom, max_stack);
	
		return (ArrayList<Box>)max_stack.clone();
	}
	public static int stackHeight(ArrayList<Box> s){
		int res = 0;
		for(Box b : s){
			res += b.height;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
