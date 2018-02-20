import java.util.*;

public class LongestDistTreeNodes {
	static class UndirectedGraphNode {
		  int val;
	      int depth;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x, int d) { val = x; depth = d; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  }
	
	public static UndirectedGraphNode[] convert(ArrayList<Integer> input) {
		UndirectedGraphNode root = new UndirectedGraphNode(0,0);
		UndirectedGraphNode[] res = new UndirectedGraphNode[input.size()];
		res[0] = root;
		for (int i = 1; i < res.length; i++) {
			res[i] = new UndirectedGraphNode(i, 0);
			res[i].neighbors.add(res[input.get(i)]);
			res[input.get(i)].neighbors.add(res[i]);
		}
		return res;
	}
	
	public static UndirectedGraphNode findMaxDepthBfs(UndirectedGraphNode[] A, UndirectedGraphNode root) {
		root.depth = 0;
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		set.add(root);
		q.add(root);
		UndirectedGraphNode maxNode = new UndirectedGraphNode(-1,-1);
		while (!q.isEmpty()) {
			UndirectedGraphNode curNode = q.poll();
			System.out.println("depth: " + curNode.depth + "label:" + curNode.val);
			maxNode = curNode;
			for (UndirectedGraphNode n : curNode.neighbors) {
				if (!set.contains(n)) {
					n.depth = curNode.depth + 1;
					set.add(n);
					q.add(n);
					System.out.println("neighbor depth: " + n.depth + "label:" + n.val);
				}
			}
		}
		return maxNode;
    }
	
	public static int solve(ArrayList<Integer> A) {
		UndirectedGraphNode[] graphNodes = convert(A);
		UndirectedGraphNode farNode = findMaxDepthBfs(graphNodes, graphNodes[0]);
		UndirectedGraphNode farestNode = findMaxDepthBfs(graphNodes,farNode);
		return farestNode.depth;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(-1);
		input.add(0);
		input.add(0);
		input.add(0);
		input.add(3);
		int dist = solve(input);
        System.out.println("Distance: " + dist);
	}
}
