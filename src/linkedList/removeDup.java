package linkedList;

import java.util.HashSet;
import java.util.Set;

import util.ListNode;

public class removeDup {
	public static void remove(ListNode head){
		Set<Integer> set = new HashSet<Integer>();
		ListNode pre =  null;
		while(head != null){
			if(set.contains(head.val))
				pre.next = head.next;
			else{
				set.add(head.val);
				pre = head;
			}
			head = head.next;
		}
	}
	public static void removeII(ListNode head){
		ListNode cur = head;
		while(cur != null){
			ListNode p = cur;
			while(p.next != null){
				if(p.next.val == cur.val)
					p.next = p.next.next;
				else
					p = p.next;
			}
			cur = cur.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		//remove(a);
		removeII(a);
		System.out.println(a.toString());
	}

}
