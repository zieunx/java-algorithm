package com.study.javaalgorithm.programmers.level3.모두0으로만들기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

	static Node[] tree = null;
	static long sum = 0;
	static long count = 0;
	static int x = 0;
	static int y = 0;

	public static long solution(int[] a, int[][] edges) {
		if (weightSum(a) != 0) {
			return -1;
		}

		// 노드 초기화
		tree = new Node[a.length];
		for (int i = 0; i < edges.length; i = i + 1) {
			x = edges[i][0];
			y = edges[i][1];

			if (tree[x] == null) {
				tree[x] = new Node(x, a[x]);
			}
			if (tree[y] == null) {
				tree[y] = new Node(y, a[y]);
			}

			tree[x].addNode(tree[y]);
			tree[y].addNode(tree[x]);
		}

		/* bfs 풀이 - 실패
		// queue 는 Leaf 로 초기화한다.
		Queue<Node> nextNodes = new LinkedList<>();

		for (Node node : tree) {
			if (node.getLinkedNodes().size() == 1 && node.getN() != 0) {
				nextNodes.add(node);
			}
		}

		return bfs(nextNodes);
		*/

		calChildWeight(tree[0]);
		return count;
	}


	//dfs
	public static long calChildWeight(Node node) {
		node.visit();

		for (Node childNode : node.getLinkedNodes()) {
			if (childNode.isNotVisited()) {
				node.addWeight(calChildWeight(childNode));
			}
		}

		count += Math.abs(node.getWeight());

		return node.getWeight();
	}

	/*public long bfs(Queue<Node> nextNodes) {
		long count = 0;
		while (!nextNodes.isEmpty()) {
			currentNode = nextNodes.poll();
			currentNode.visit();

			for(Node parentNode : currentNode.getLinkedNodes()) {
				if (parentNode.isNotVisited()) {
					parentNode.addWeight(currentNode.getWeight());
					count = count + Math.abs(currentNode.getWeight());

					nextNodes.add(parentNode);
				}
			}
		}

		return count;
	}*/

	private static long weightSum(int[] a) {
		sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}
}

class Node {
	private final long n;
	private final Map<Node, Integer> linkedNodes;
	private long weight;
	private boolean visited;

	public Node(long n, long weight) {
		this.n = n;
		this.weight = weight;
		this.visited = false;
		this.linkedNodes = new HashMap<>();
	}

	public Set<Node> getLinkedNodes() {
		return linkedNodes.keySet();
	}

	public void visit() {
		visited = true;
	}

	public boolean isNotVisited() {
		return !visited;
	}

	public long getWeight() {
		return weight;
	}

	public long getN() {
		return n;
	}

	public void addWeight(long weight) {
		this.weight = this.weight + weight;
	}

	public void addNode(Node node) {
		linkedNodes.put(node, 0);
	}
}