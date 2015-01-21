package util;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public String toString() {
		String s = "";
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = this;
		q.add(root);
		while(!q.isEmpty()){
			TreeNode t = q.poll();
			s += t.val + " ";
			if(t.left != null)
				q.add(t.left);
			if(t.right != null)
				q.add(t.right);
		}
		
		return s;
	}
	public String toStringlevel(){
		String s = "";
		Queue<TreeNode> c = new LinkedList<TreeNode>();
		Queue<TreeNode> n = new LinkedList<TreeNode>();
		TreeNode root = this;
		c.add(root);
		while(!c.isEmpty()){
			TreeNode t = c.poll();
			s += t.val + " ";
			if(t.left != null)
				n .add(t.left);
			if(t.right != null)
				n.add(t.right);
			if(c.isEmpty()){
				s += "\n";
				c.addAll(n);
				n.clear();
			}
		}
		
		return s;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		a.right = c;
		b.right = d;
		System.out.println(root.toStringlevel());
		System.out.println(root);
			
	}
}

