package treeGraph;

import util.TreeNode;

public class isBST {
	public static boolean isbst(TreeNode root){
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean check(TreeNode root, int min, int max){
		if(root == null) 
			return true;
		if(root.val <= min ||root.val >= max)
			return false;
		if(!check(root.left, min, root.val) || !check(root.right, root.val, max))
			return false;
		
		return true;
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
		System.out.println(isbst(root));
	}

}
