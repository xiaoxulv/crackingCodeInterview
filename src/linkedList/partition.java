package linkedList;

import util.ListNode;

public class partition {
	public static ListNode part(ListNode head, int x){
		ListNode p = null;
		ListNode q = null;
		while(head != null){
			ListNode next = head.next;
			if(head.val < x){
				head.next = p;
				p = head;
			}else{
				head.next = q;
				q = head;
			}
			head = next;
		}
		if(p == null)
			return q;
		ListNode cur = p;
		while(p.next != null)
			p = p.next;
		p.next = q;
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;

		System.out.println(part(a, 3).toString());
	}

}
