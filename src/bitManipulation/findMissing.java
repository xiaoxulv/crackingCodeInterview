package bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findMissing {
	 // convert to BitInterger
	public static ArrayList<Integer> getBit(ArrayList<Integer> a){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Integer t : a){
			//System.out.println("inlist : " + t);
			res.add(Integer.parseInt(Integer.toBinaryString(t)));
		}
		return res;
	}
	// only allowed function for access the array here
	// find the jth bit of a[i]
	// assume that j < 32 and 0 < i < a.len
	public static int fetch(ArrayList<Integer> a, int i, int j){
		return a.get(i)/(int)Math.pow(10,j) & 1;
	}
	static int size = 0;
	public static int findMiss(ArrayList<Integer> a){
		ArrayList<Integer> bitInt = getBit(a);
		size = (int) (Math.ceil(Math.log10(bitInt.get(a.size()-1))));
		return find(bitInt, 0);
	}
	public static int find(ArrayList<Integer> a, int col){
		if(col > size )
			return 0;
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a0 = new ArrayList<Integer>();
		for(int i = 0; i < a.size(); i++){
			if(fetch(a, i, col) == 0)
				a0.add(a.get(i));
			else
				a1.add(a.get(i));
		}
		if(a0.size() <= a1.size()){
			int v = find(a0, col+1);
			return (v<<1) | 0;
		}else{
			int v = find(a1, col+1);
			return (v<<1) | 1;
		}
	}
	
	
//	// only allowed function for access the array here
//	// find the jth bit of a[i]
//	// assume that j < 32 and 0 < i < a.len
//	public static int fetch(ArrayList<Integer> a , int i, int j){
//		return a.get(i)>>j;
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		//ArrayList<Integer> b = new ArrayList<Integer>();
		Collections.addAll(a, 0,1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,18);
		//System.out.println(fetch(a, 6, 3));
		//System.out.println(Math.ceil(Math.log(a.size())/Math.log(2)));
		//b = getBit(a);
		System.out.println(a);
		System.out.println(fetch(a,9,1));
		System.out.println(findMiss(a));

	}

}
