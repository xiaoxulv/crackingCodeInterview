package treeGraph;

import java.util.LinkedList;
import java.util.Queue;

import util.UndirectedGraphNode;


public class route {
	
	
	public static boolean bfsRoute(UndirectedGraphNode src, UndirectedGraphNode dst){
		boolean[] visited = new boolean[1000];
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.add(src);
		visited[src.getLabel()] = true;

		while(!q.isEmpty()){
			UndirectedGraphNode v = q.poll();
			visited[v.getLabel()] = true;
			if(v == dst) return true;
			for(UndirectedGraphNode t : v.neighbors){
				if(!visited[t.getLabel()]){
					visited[t.getLabel()] = true;
					q.add(t);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode a  = new UndirectedGraphNode(1);
		UndirectedGraphNode b  = new UndirectedGraphNode(2);
		UndirectedGraphNode c  = new UndirectedGraphNode(3);
		UndirectedGraphNode d  = new UndirectedGraphNode(4);
		UndirectedGraphNode e  = new UndirectedGraphNode(5);
		UndirectedGraphNode f  = new UndirectedGraphNode(6);
		a.neighbors.add(b);
		b.neighbors.add(c);
		b.neighbors.add(d);
		c.neighbors.add(e);
		System.out.println(bfsRoute(a,d));
	
	}

}
