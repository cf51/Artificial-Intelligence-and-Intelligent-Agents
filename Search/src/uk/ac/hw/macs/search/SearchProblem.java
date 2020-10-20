package uk.ac.hw.macs.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import uk.ac.hw.macs.search.example.DepthFirstSearchOrder;
import uk.ac.hw.macs.search.example.IntState;

/**
 * Represents a search problem.
 * 
 * @author Mary Ellen Foster <MaryEllen.Foster@glasgow.ac.uk>
 */
public class SearchProblem {
	
	private SearchOrder searchOrder;
	
	public SearchProblem(SearchOrder searchOrder) {
		this.searchOrder = searchOrder;
	}

	public boolean doSearch(Node root) {
		List<FrontierNode> frontier = new LinkedList();
		frontier.add(new FrontierNode(root, null, 0));
		Set<Node> visitedStates = new HashSet();	
		FrontierNode goalNode = null;
		
		while (true) {
			if (frontier.isEmpty()) {
				// We didn't find it
				break;
			}
			
			FrontierNode searchNode = frontier.remove(0);
			System.out.println("Current node: " + searchNode);
			
			// If current node is on block list, ignore it
			if (visitedStates.contains(searchNode.node)) {
				continue;
			}
			
			// Have we reached a goal state? If so, we're done
			if (searchNode.node.isGoal()) {
				goalNode = searchNode;
				break;
			}
			
			// Otherwise: Expand current node
			searchOrder.addToFrontier(frontier, searchNode, searchNode.node.getChildren());
			visitedStates.add(searchNode.node);
		}
		
		if (goalNode == null) {
			System.out.println("No goal found");
			return false;
		} else {
			System.out.println("Found goal node: " + goalNode.node);
			System.out.println("Cost: " + goalNode.cost);
			System.out.println("Nodes expanded: " + visitedStates.size());
			System.out.println("Path to root:");
			FrontierNode fnode = goalNode;
			while (fnode != null) {
				System.out.println("- node: " + fnode.node.getValue());
				fnode = fnode.parent;
			}
			return true;
		}

	}

}
