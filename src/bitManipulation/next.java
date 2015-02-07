package bitManipulation;

import java.util.Arrays;

// java precedence operator: arithmetic > logic
public class next {
	public static int nextBig(int n){
		// get right-most non-trailing 0 and turn it to 1
		// to its right, first 0 then 1
		int copy = n;
		int c1 = 0;
		int c0 = 0;
		while(((copy&1) == 0) && (copy!=0)) {
			c0++;
			copy >>= 1;
		}
		while((copy&1) == 1){
			c1++;
			copy >>= 1;
		}
		int p = c1+c0;
		if(p == 0 || p == 31)//1..10..0 can't be bigger
			return -1;
		n |= (1<<p); //flip 
		n &= ~((1<<p) - 1); //clear
		n |= (1<<(c1-1)) - 1; // add 0../1..
		return n;
	}
	public static int nextSmall(int n){
		// get right-most non-trailing 1 and turn it to 0
		// to its right, first 1 then 0
		int copy = n;
		int c1 = 0;
		int c0 = 0;
		while((copy&1) == 1) {
			c1++;
			copy >>= 1;
		}
		if(copy == 0) return -1;
		
		while(((copy&1) == 0) && (copy!=0)){
			c0++;
			copy>>=1;
		}
		int p = c0+c1;
		n &= (~0)<<(p+1); //clear, flip as well
		int mask = (1<<(c1+1))-1;//add 1
		n |= mask<<(c0-1);
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 37 = 100101
		System.out.println(nextBig(37));
		System.out.println(nextSmall(37));
	}

}
