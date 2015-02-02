package treeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class createLinkedList {

	public static List<List<TreeNode>> level(TreeNode root){
		List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
		List<TreeNode> in = new LinkedList<TreeNode>();
		Queue<TreeNode> cur = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		
		if(root != null)
			cur.add(root);
		while(!cur.isEmpty()){
			TreeNode t = cur.poll();
			in.add(t);
			if(t.left != null)
				next.add(t.left);
			if(t.right != null)
				next.add(t.right);
			if(cur.isEmpty()){
				res.add(new ArrayList<TreeNode>(in));
				in.clear();
				cur.addAll(next);
				next.clear();
			}
		}
		return res;
	}
	public static LinkedList<LinkedList<TreeNode>> createLevelLinkedList(
            TreeNode root) {
        LinkedList<LinkedList<TreeNode>> lists = new
            LinkedList<LinkedList<TreeNode>>();

        createLevelLinkedList(root, 0, lists);
        return lists;
    }

	//recursive
    public static void createLevelLinkedList(TreeNode node, int level,
            LinkedList<LinkedList<TreeNode>> lists) {
        if(node == null)
            return;

        if(lists.size() == level)
            lists.add(new LinkedList<TreeNode>());

        LinkedList<TreeNode> list = lists.get(level);
        list.add(node);

        createLevelLinkedList(node.left, level + 1, lists);
        createLevelLinkedList(node.right, level + 1, lists);
    }
    // level order
	public static LinkedList<LinkedList<TreeNode>> createLevelLinkedList2(
            TreeNode root) {
        LinkedList<LinkedList<TreeNode>> lists = new
            LinkedList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root != null)
            current.add(root);

        while(current.size() > 0) {
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();

            for(TreeNode parent : parents) {
                if(parent.left != null)
                    current.add(parent.left);

                if(parent.right != null)
                    current.add(parent.right);
            }
        }

        return lists;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		//a.right = c;
		//b.right = d;
		
		System.out.println(level(root));
		System.out.println(createLevelLinkedList2(root));
	}

}
