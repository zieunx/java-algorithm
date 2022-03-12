package com.study.javaalgorithm.test.t0312.q4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public long solution(int n, int[][] edges) {
		long answer = 0;
		Node[] tree = initTree(n, edges);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < n; k++) {
					if (i == k || j == k) {
						continue;
					}
					int a = distance(tree[i], tree[j]);
					initVisited(tree);
					int b = distance(tree[j], tree[k]);
					initVisited(tree);
					int c = distance(tree[i], tree[k]);
					initVisited(tree);

					if (a + b == c) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	public int distance(Node startNode, Node endNode) {
		boolean find = false;
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(startNode);

		while (!find && !nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.poll();

			for (Node linkedNode : currentNode.getLinkedNodes()) {
				if (linkedNode.isNotVisited() && linkedNode != startNode) {
					linkedNode.visit(currentNode.getDepth() + 1);
					nodeQueue.add(linkedNode);
				}
				if (linkedNode.getN() == endNode.getN()) {
					endNode.visit(linkedNode.getDepth());
					find = true;
				}
			}
		}

		return endNode.getDepth();
	}

	private void initVisited(Node[] tree) {
		for (Node node : tree) {
			node.visit(0);
		}
	}

	private Node[] initTree(int n, int[][] edges) {
		Node[] tree = new Node[n];
		for (int i = 0; i < edges.length; i = i + 1) {
			int a = edges[i][0];
			int b = edges[i][1];

			if (tree[a] == null) {
				tree[a] = new Node(a);
			}
			if (tree[b] == null) {
				tree[b] = new Node(b);
			}

			tree[a].add(tree[b]);
			tree[b].add(tree[a]);
		}
		return tree;
	}
}


class Node {
	private int n;
	private int depth;
	private Map<Node, Integer> linkedNodes;

	public Node(int n) {
		this.n = n;
		this.linkedNodes = new HashMap<>();
	}

	public void add(Node linkedNode) {
		linkedNodes.put(linkedNode, 0);
	}

	public Set<Node> getLinkedNodes() {
		return linkedNodes.keySet();
	}

	public void visit(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public boolean isNotVisited() {
		return depth == 0;
	}

	public int getN() {
		return n;
	}
}

