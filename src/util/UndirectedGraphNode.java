package util;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

	private int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		setLabel(x);
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
}
