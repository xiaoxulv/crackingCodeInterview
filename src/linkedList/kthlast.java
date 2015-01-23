package linkedList;

import util.ListNode;

public class kthlast {
	public static ListNode klast(ListNode head, int k){
		ListNode p = head;
		ListNode q = head;
		k--;
		while(k > 0){
			if(q == null)
				return null;
			q = q.next;
			k--;
		}
		if(q == null)
			return null;
		while(q.next != null){
			q = q.next;
			p = p.next;
		}
		return p;
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
		System.out.println(klast(a, 5).toString());
	
	}

}
