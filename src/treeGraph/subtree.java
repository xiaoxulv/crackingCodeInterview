package treeGraph;

import util.TreeNode;

public class subtree {
	public static boolean isSubtree(TreeNode t1, TreeNode t2){
		if(t2 == null) return true;
		return contains(t1, t2);
	} 
	public static boolean contains(TreeNode t1, TreeNode t2){
		if(t1 == null)
			return false;
		if(t1.val == t2.val)
			return isSameTree(t1, t2);
		return contains(t1.left, t2)||contains(t1.right, t2);
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
			return true;
		if(p == null && q!= null)
			return false;
		if(p != null && q == null)
			return false;
		if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		a.left = c;
		b.right = d;
		System.out.println(isSubtree(c, a));
	}

}
