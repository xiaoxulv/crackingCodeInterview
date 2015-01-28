package linkedList;

import java.util.LinkedList;
import java.util.Stack;

import util.ListNode;

public class addList {
	public static ListNode add(ListNode l1, ListNode l2){
		int len1 = len(l1);
		int len2 = len(l2);
		if(len1 < len2)
			l1 = padZeros(l1, len2-len1);
		else
			l2 = padZeros(l2, len1-len2);
		partial psum = helper(l1,l2);
		if(psum.carry == 0)
			return psum.sum;
		else{
			ListNode res = insertBefore(psum.sum, psum.carry);
			return res;
		}
	}
	public static partial helper(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null){
			partial p = new partial();
			return p;
		}
		partial p = helper(l1.next, l2.next);
		int val = l1.val+l2.val+p.carry;
		ListNode res = insertBefore(p.sum, val%10);
		p.sum = res;
		p.carry = val/10;
		return p;
			
	}
	public static class partial{
		public ListNode sum = null;
		public int carry = 0;
	}
	// useful utils 
	public static int len(ListNode head){
		int n = 0;
		while(head != null){
			n++;
			head = head.next;
		}
		return n;
	}
	public static ListNode padZeros(ListNode head, int num){
		for(int i = 0; i < num; i++){
			ListNode l = new ListNode(0);
			l.next = head;
			head = l;
		}
		return head;
	}
	public static ListNode insertBefore(ListNode head, int val){
		ListNode n = new ListNode(val);
		n.next = head;
		head = n;
		return head;
	}
	
	// use 3 stacks 
	public static ListNode addlist(ListNode l1, ListNode l2){
		Stack<Integer> s1 = new Stack<Integer>();
		ListNode head1 = l1;
		while(head1 != null){
			s1.push(head1.val);
			head1 = head1.next;
		}
		Stack<Integer> s2 = new Stack<Integer>();
		ListNode head2 =l2;
		while(head2 != null){
			s2.push(head2.val);
			head2 = head2.next;
		}
		Stack<Integer> s = new Stack<Integer>();
		int carry = 0;
		
		while(!s1.isEmpty()||!s2.isEmpty()||carry == 1){
			int val = carry;
			if(!s1.isEmpty())
				val += s1.pop();
			if(!s2.isEmpty())
				val += s2.pop();
			s.push(val%10);
			carry = val/10;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(!s.isEmpty()){
			ListNode n = new ListNode(s.pop());
			cur.next = n;
			cur = n;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(9);
		ListNode c = new ListNode(9);
		a.next = b;
		b.next = c;	
		
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(1);
		
		d.next = e;

		System.out.println(len(a));
		System.out.println(padZeros(a, 4).toString());
		System.out.println(insertBefore(a, 4));
		System.out.println(add(a, d).toString());
		System.out.println(addlist(a,d).toString());
	}

}

