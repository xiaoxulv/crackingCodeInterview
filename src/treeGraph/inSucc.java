package treeGraph;

import util.TreeNode;

public class inSucc {
	public static TreeNode insucc(TreeNode t){
		if(t == null) return null;
		TreeNode n = t;
		if(n.right != null){
			n = n.right;
			while(n.left != null)
				n = n.left;
			return n;
		}
		else{
			TreeNode p = n.parent;
			while(p.left != n && p != null){
				n = p;
				p = n.parent;
			}
			return p;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(9);
		root.left = a;
		a.parent = root;
		root.right = b;
		b.parent = root;
		a.left = c;
		c.parent = a;
		b.right = d;
		d.parent = b;
		System.out.println(insucc(c).val);
	}

}
