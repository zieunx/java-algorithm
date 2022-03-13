package com.study.javaalgorithm.programmers.level3.모두0으로만들기;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Solution {
	public long solution(int[] a, int[][] edges) {
		if (weightSum(a) != 0) {
			return -1;
		}

		// 노드 초기화
		Node[] tree = new Node[a.length];
		for (int i = 0; i < edges.length; i = i + 1) {
			int x = edges[i][0];
			int y = edges[i][1];

			if (tree[x] == null) {
				tree[x] = new Node(x, a[x]);
			}
			if (tree[y] == null) {
				tree[y] = new Node(y, a[y]);
			}

			tree[x].addNode(tree[y]);
			tree[y].addNode(tree[x]);
		}

		// queue 는 Leaf 로 초기화한다.
		Queue<Node> nextNodes = new LinkedList<>();

		for (Node node : tree) {
			if (node.getLinkedNodes().size() == 1 && node.getN() != 0) {
				nextNodes.add(node);
			}
		}

		return bfs(nextNodes);
	}

	public long bfs(Queue<Node> nextNodes) {
		long count = 0;
		while (!nextNodes.isEmpty()) {
			Node currentNode = nextNodes.poll();
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
	}

	private int weightSum(int[] a) {
		int sum = 0;
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