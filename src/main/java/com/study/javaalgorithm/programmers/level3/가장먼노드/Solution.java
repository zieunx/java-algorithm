package com.study.javaalgorithm.programmers.level3.가장먼노드;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	public int solution(int n, int[][] edge) {

		Node[] tree = new Node[n];
		for (int i = 0; i < edge.length; i = i + 1) {
			int a = edge[i][0] - 1;
			int b = edge[i][1] - 1;

			if (tree[a] == null) {
				tree[a] = new Node(a);
			}
			if (tree[b] == null) {
				tree[b] = new Node(b);
			}

			tree[a].addNode(tree[b]);
			tree[b].addNode(tree[a]);
		}

		Queue<Node> nodeQueue = new LinkedList<>();

		nodeQueue.add(tree[0]);

		findLastNode(nodeQueue);

		Map<Integer, List<Node>> collect = Stream.of(tree).collect(Collectors.groupingBy(Node::getDepth));

		Integer maxKey = collect.keySet().stream().max(Comparator.naturalOrder()).get();

		return collect.get(maxKey).size();
	}

	// dfs
	public void findLastNode(Queue<Node> nextNodes) {

		while (!nextNodes.isEmpty()) {
			Node currentNode = nextNodes.poll();

			for (Node linkedNode : currentNode.getLinkedNodes()) {
				if (linkedNode.isNotVisited() && linkedNode.getN() != 0) {
					linkedNode.visit(currentNode.getDepth() + 1);
					nextNodes.add(linkedNode);
				}
			}
		}
	}
}

class Node {
	private int n;
	private int depth;
	private Map<Node, Integer> linkedNodes;

	public Node(int n) {
		this.n = n;
		this.depth = 1;
		this.linkedNodes = new HashMap<>();
	}

	public void addNode(Node item) {
		linkedNodes.put(item, 0);
	}

	public Set<Node> getLinkedNodes() {
		return linkedNodes.keySet();
	}

	public int getDepth() {
		return depth;
	}

	public boolean isNotVisited() {
		return depth == 1;
	}

	public void visit(int depth) {
		this.depth = depth;
	}

	public int getN() {
		return n;
	}
}
