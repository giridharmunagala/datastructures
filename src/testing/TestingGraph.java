package testing;

import datastructures.Graph;

public class TestingGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> graph = new Graph<String>();
//		Nodes
		String apple = "Apple";
		String mango = "Mango";
		String orange = "Orange";
		String banana = "Banana";
		String grape = "Grape";
		graph.addNode(apple);
		graph.addNode(grape);
		graph.addNode(orange);
		graph.addNode(banana);
		graph.addNode(mango);
		graph.addEdge(apple, orange);
		graph.addEdge(banana, orange);
		graph.addEdge(grape, orange);
		graph.addEdge(grape, banana);
		graph.addEdge(mango, apple);
		for(String fruit:graph.depthFirstSearch(orange)) {
			System.out.println(fruit);
		}

	}

}
