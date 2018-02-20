import java.util.*;

public class CloneGraph {
	// [label:1  neighbors:([label:2 neighbors()], [label:3 neighbors()])]
	 // Definition for undirected graph.
	  static class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };
	  
	  public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		  Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		  HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		  
		  queue.add(node);
		  UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		  map.put(node, newHead);
		  
		  while (!queue.isEmpty()) {
			  UndirectedGraphNode curNode = queue.poll();
			  List<UndirectedGraphNode> neighbors = curNode.neighbors; 
			  for (UndirectedGraphNode aNeighbor : neighbors) {
				  if (map.containsKey(aNeighbor)) {
					  // Do not copy, but connect two nodes
					  map.get(curNode).neighbors.add(map.get(aNeighbor));
				  } else {
					  // Copy the node
					  UndirectedGraphNode copyNode = new UndirectedGraphNode(aNeighbor.label);
					  System.out.print("Copy node lable: " + copyNode.label);
					  // Put the copy node in the map, the key is it's original node
					  map.put(aNeighbor, copyNode);
					  // Connect the copy version of neighbor node to the main copy graph
					  map.get(curNode).neighbors.add(copyNode);
					  // Put the rest of the neighbors to the queue
					  queue.add(aNeighbor);
				  }
			  }
		  }
		  return newHead;  
	  }
	  
	  public static void main(String[] args) {
		  UndirectedGraphNode root = new UndirectedGraphNode(1);
		  ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
		  neighbors.add(new UndirectedGraphNode(2));
		  neighbors.add(new UndirectedGraphNode(3));
		  root.neighbors = neighbors;
		  
		  UndirectedGraphNode copy = cloneGraph(root);
		  
		  return;
	  }
}
