package treeGraph;

import util.TreeNode;

public class sum {
	public static void findSum(TreeNode root, int sum){
		int depth = maxDepth(root);
		int[] path = new int[depth];
		find(root, sum, path, 0);
	}
	public static void find(TreeNode root, int sum, int[] path, int level){
		if(root == null) return;
		path[level] = root.val;
		int t = 0;
		for(int i = level; i >= 0; i--){
			t += path[i];
			if(sum == t)
				printpath(path, i, level);
		}
		find(root.left, sum, path,level+1);
		find(root.right, sum, path,level+1);
		
	}
	public static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r)+1;
    }
	public static void printpath(int[] path, int start, int end){
		for(int i = start; i <= end; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(13);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		a.left = c;
		b.right = d;
		findSum(root,21);
	}

}
