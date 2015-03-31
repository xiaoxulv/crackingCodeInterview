package sortSearch;

public class search {
	public int searchStr(String[] strs, String target) {
		if (strs == null || target == null || target == "")
			return -1;
		return searchStr(strs, target, 0, strs.length - 1);
	}

	private int searchStr(String[] strs, String target, int left, int right) {
		if (right < left)
			return -1;
		int mid = left + (right - left) / 2;
		if (strs[mid].isEmpty()) {
			int ml = mid - 1;
			int mr = mid + 1;
			while (true) {
				if (ml < left || mr > right)
					return -1;
				else if (mr <= right && !strs[mr].isEmpty()) {
					mid = mr;
					break;
				} else if (ml >= left && !strs[ml].isEmpty()) {
					mid = ml;
					break;
				}
				ml--;
				mr++;
			}
		}
		if (strs[mid] == target)
			return mid;
		else if (strs[mid].compareTo(target) < 0)
			return searchStr(strs, target, mid + 1, right);
		else
			return searchStr(strs, target, left, mid - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search s = new search();
		String[] str = {"abc", "", "", "dfg",""};
		System.out.println(s.searchStr(str,"dfg"));

	}

}
