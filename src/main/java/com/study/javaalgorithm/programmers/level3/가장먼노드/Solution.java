package com.study.javaalgorithm.programmers.level3.가장먼노드;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
	public int solution(int n, int[][] edge) {
		int answer = 0;

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

		tree[0].updateDepth(1);

		answer = findLastNode(tree[0], tree[0].getDepth() + 1);

		return answer;
	}

	public int findLastNode(Node node, int currentDepth) {
		int max = currentDepth;
		for (Node linkedNode : node.getLinkedNodes()) {
			if (linkedNode.isNotVisited()) {
				// 재귀호출
				linkedNode.visit(currentDepth);
				max = Math.max(currentDepth, findLastNode(linkedNode, currentDepth + 1));
			}
		}

		return max;
	}
}

class Node {
	private int n;
	private int depth;
	private Map<Node, Integer> linkedNodes;

	public Node(int n) {
		this.n = n;
		this.depth = 0;
		this.linkedNodes = new HashMap<>();
	}

	public void addNode(Node item) {
		linkedNodes.put(item, 0);
	}

	public Set<Node> getLinkedNodes() {
		return linkedNodes.keySet();
	}

	public void updateDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public boolean isNotVisited() {
		return depth == 0;
	}

	public void visit(int depth) {
		this.depth = depth;
	}
}
