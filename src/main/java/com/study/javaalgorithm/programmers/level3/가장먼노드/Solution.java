package com.study.javaalgorithm.programmers.level3.가장먼노드;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

		Queue<Node> nodeQueue = new LinkedList<>();

		tree[0].visit(1);
		nodeQueue.add(tree[0]);

		answer = findLastNode(nodeQueue);

		return answer;
	}

	// dfs
	public int findLastNode(Queue<Node> nextNodes) {
		int max = 1;

		while (!nextNodes.isEmpty()) {
			Node currentNode = nextNodes.poll();
			max = Math.max(max, currentNode.getDepth());
			System.out.println("current node : " + (currentNode.getN() + 1) + " / depth : " + currentNode.getDepth());

			for (Node linkedNode : currentNode.getLinkedNodes()) {
				if (linkedNode.isNotVisited()) {
					System.out.println(" > linked node : " + (linkedNode.getN() + 1) + " / depth : " + currentNode.getDepth());
					linkedNode.visit(currentNode.getDepth() + 1);
					nextNodes.add(linkedNode);
				}
			}
		}

		return max;
	}

	/*
	public int findLastNode(Node node, int currentDepth) {
		int max = currentDepth;
		System.out.println("current node : " + (node.getN() + 1) + " / depth : " + currentDepth);
		for (Node linkedNode : node.getLinkedNodes()) {
			// 재귀호출
			System.out.println(" >> call linked node :" + linkedNode.getN());
			linkedNode.visit(currentDepth);
			max = Math.max(currentDepth, findLastNode(linkedNode, currentDepth + 1));
		}

		return max;
	}
	*/
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

	public int getDepth() {
		return depth;
	}

	public boolean isNotVisited() {
		return depth == 0;
	}

	public void visit(int depth) {
		this.depth = Math.min(this.depth, depth);
	}

	public int getN() {
		return n;
	}
}
