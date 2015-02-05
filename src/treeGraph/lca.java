package treeGraph;

import util.TreeNode;

public class lca {
	public static boolean inTree(TreeNode root, TreeNode t){
		if(root == null) return false;
		if(root == t) return true;
		return inTree(root.left, t) || inTree(root.right, t);
		
	}
	public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
		if(!inTree(root, p)||!inTree(root,q))// really need to check
			return null;
		//return lowestCommonAncestor(root, p ,q);
		return Lowest(root, p, q);
	}
	public static TreeNode lowestCommonAncestor(TreeNode root, 
			TreeNode p, TreeNode q){
		
		if(root == null) return null;
		if(root == p||root == q) return root;
		
		boolean pleft = inTree(root.left, p);
		boolean qleft = inTree(root.left, q);
		if(pleft != qleft)
			return root;
		TreeNode next = null;
		if(pleft)
			next = root.left;
		else
			next = root.right;
		
		return lowestCommonAncestor(next, p ,q) ;
	}
	
	//another approach, also needs checking before 
	public static TreeNode Lowest(TreeNode root, TreeNode p, 
			TreeNode q){
		
		if(root == null) return null;
		if(root == p && root == q) return root;
		TreeNode x = Lowest(root.left, p, q);
		if(x != null && x != p && x!= q)
			return x;
		TreeNode y = Lowest(root.right, p, q);
		if(y != null && y != p && y!= q)
			return y;
		if(x != null && y != null)
			return root;
		else if(root == p || root == q)
			return root;
		else 
			return x == null? y : x;
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
		System.out.println(LCA(root, a, d).val);
	}

}
