package linkedList;

import java.util.Stack;

import util.ListNode;

public class palindrome {
	// use a stack
	public static boolean ifPalindrome(ListNode head){
		if(head == null||head.next == null)
			return true;
		Stack<Integer> s = new Stack<Integer>();
		ListNode p = head;
		ListNode q = p;
		while(q.next != null&&q != null){
			s.push(p.val);
			p = p.next;
			q = q.next.next;
		}
		if(q != null)
			p = p.next;
		while(p != null){
			if(s.pop() != p.val)
				return false;
		}
		return true;
	}

	
	// reverse and compare directly, really straight forward
	// iterative
	public static ListNode reverse(ListNode head){
		if(head == null|| head.next == null)
			return head;
		ListNode cur = head;
		ListNode pre = null;
		ListNode tmp;
		while(cur != null){
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
	//recursive
	public static ListNode reverse2(ListNode head){
		if(head == null|| head.next == null)
			return head;
		ListNode p = reverse2(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(1);
		a.next = b;
		b.next = c;
		//c.next = d;
		ListNode h = reverse2(a);
		System.out.println(h.toString());
		System.out.println(ifPalindrome(a));
	}

}
