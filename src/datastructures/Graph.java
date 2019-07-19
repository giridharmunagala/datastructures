package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Graph<E> {
	HashMap<E, LinkedList<E>> adjacencyList;
	
	public Graph() {
		adjacencyList = new HashMap<E, LinkedList<E>>();
	}
	
	public void addNode(E node) {
		if(!adjacencyList.containsKey(node)) {
			adjacencyList.put(node, new LinkedList<E>());
		}
	}
	
	public void addEdge(E firstNode, E secondNode) {
		if (!doesEdgeExits(firstNode,secondNode)) {
			adjacencyList.get(firstNode).push(secondNode);
			adjacencyList.get(secondNode).push(firstNode);
		}
	}
	
	private boolean doesEdgeExits(E firstNode, E secondNode) {
		boolean edgeExists = false;
		LinkedList<E> edgeNodes = adjacencyList.get(firstNode);
		
		for(E node : edgeNodes) {
			if(node.equals(secondNode)) {
				edgeExists = true;
				break;
			}
		}
		
		return edgeExists;
	}
	
	public ArrayList<E> depthFirstSearch(E dfsStartNode){
		ArrayList<E> dfsNodes = new ArrayList<E>();
		Stack<E> nodesStack = new Stack<E>();
		HashMap<E, Boolean> visitedMap = new HashMap<E, Boolean>();
//		Initialising all visited values to false
		
		for(E key:adjacencyList.keySet()) {
			visitedMap.put(key, false);
		}
		
		nodesStack.push(dfsStartNode);
		
		while(!nodesStack.isEmpty()) {
			E currentNode = nodesStack.pop();
			if(!visitedMap.get(currentNode)) {
				dfsNodes.add(currentNode);
				visitedMap.put(currentNode, true);
			}
			
			for(E edgeNode: adjacencyList.get(currentNode)) {
				if(!visitedMap.get(edgeNode)) {
					nodesStack.push(edgeNode);
				}	
			}
		}
		return dfsNodes;
	}
	
	
}
