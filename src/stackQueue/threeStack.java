package stackQueue;

public class threeStack {
	int size = 1000;
	int s[] = new int[3*size];
	int p[] = {-1,-1,-1};
	public void push(int snum, int val) throws Exception{
		if(p[snum]+1 >= size)
			throw new Exception("out of space");
		p[snum]++;
		s[getIndex(snum)] = val;
	}
	public void pop(int snum) throws Exception{
		if(p[snum] == -1)
			throw new Exception("try to pop from empty stack");
		p[snum]--;
	}
	public int peek(int snum){
		return s[getIndex(snum)];
	}
	public int getIndex(int snum){
		return snum*size + p[snum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeStack t = new threeStack();
		try {
			t.pop(0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			t.push(0, 12);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.push(1, 13);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.push(2, 15);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.peek(0));
	}

}
