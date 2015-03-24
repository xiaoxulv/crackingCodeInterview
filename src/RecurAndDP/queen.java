package RecurAndDP;

import java.util.ArrayList;

public class queen {
	//only check same column or diagonal
	public boolean isValid(Integer[] column, int row, int col){
		for(int i = 0; i < row; i++){
			int c = column[i];
			if(col == c) return false;
			
			int cdis = Math.abs(col-c);
			int rdis = row-i;
			if(cdis == rdis) return false;
		}
		return true;
	}
	public void place(int row, Integer[] column, ArrayList<Integer[]> res){
		if(row == 8)
			res.add(column.clone());//!!!!clone here, copy object, not reference!!
		else{
			for(int i = 0; i < 8; i++){
				if(isValid(column, row, i)){
					column[row] = i;
					place(row+1, column,res);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queen q = new queen();
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		Integer[] c = new Integer[8];
		q.place(0,c,res);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++)
				System.out.print(res.get(i)[j]);
			System.out.println();
		}
	}

}
