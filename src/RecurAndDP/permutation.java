package RecurAndDP;

import java.util.ArrayList;
import java.util.List;

public class permutation {
	public List<String> perm(String str) {
		List<String> l = new ArrayList<String>();
		permu("", str, l);
		return l;
	}

	private void permu(String prefix, String str, List<String> l) {
		int n = str.length();
		if (n == 0)
			l.add(prefix);
		else {
			for (int i = 0; i < n; i++)
				permu(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n), l);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation p = new permutation();
		System.out.println(p.perm("asd"));
	}

}
