package linkedList;

import util.ListNode;

public class removeTarget {
	public static boolean remove(ListNode target){
		if(target == null||target.next == null)
			return false;
		ListNode sub = target.next;
		target.val = sub.val;
		target.next = sub.next;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		System.out.println(remove(c));
		System.out.println(a.toString());
	}

}
