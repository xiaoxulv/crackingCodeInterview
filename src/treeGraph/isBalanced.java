package treeGraph;

import util.TreeNode;

public class isBalanced {
	//better time complexity, O(N)
	public static boolean isBalance(TreeNode root){
		if(checkHeight(root) == -1)
			return false;
		else return true;
		
	}
	public static int checkHeight(TreeNode root){
		if(root == null)
			return 0;
		int l = checkHeight(root.left);
		if(l == -1) return -1;
		int r = checkHeight(root.right);
		if(r == -1) return -1;
		
		if(Math.abs(l-r) > 1)
			return -1;
		else
			return Math.max(l,r)+1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		root.left = a;
		//root.right = b;
		a.right = c;
		//b.right = d;
		System.out.println(isBalance(root));
	}

}
