package util;


public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public String toString() {
		ListNode n = this;
		String s = "";
		while (n != null) {
			s += n.val + " ";
			n = n.next;
		}
		return s;
	}
}