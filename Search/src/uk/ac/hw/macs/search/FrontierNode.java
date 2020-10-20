package uk.ac.hw.macs.search;

public class FrontierNode {
	public Node node;
	public FrontierNode parent;
	public int cost;
	
	public FrontierNode(Node node, FrontierNode parent, int cost) {
		this.node = node;
		this.parent = parent;
		this.cost = cost;
		if (parent != null) {
			this.cost += parent.cost;
		}
	}

	@Override
	public String toString() {
		return "FrontierNode [node=" + node + ", parent=" + parent + ", cost=" + cost + "]";
	}
	
	
}
