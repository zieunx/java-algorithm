package com.study.javaalgorithm.programmers.level3.모두0으로만들기;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
	public long solution(int[] a, int[][] edges) {
		long answer = -2;

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

		// bfs 호출

		return answer;
	}

	public long findAddValue(Node node) {
		long count = 0;
		for(Node linkNode : node.getLinkedNodes()) {
			if (node.isNotVisited()) {
				node.addWeight(linkNode.getWeight());
				count = count + Math.abs(linkNode.getWeight());
				node.visit();
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
	private long n;
	private long weight;
	private Map<Node, Integer> linkedNodes;

	public Node(long n, long weight) {
		this.n = n;
		this.weight = weight;
		this.linkedNodes = new HashMap<>();
	}

	public Set<Node> getLinkedNodes() {
		return linkedNodes.keySet();
	}

	public void visit() {
		weight = 0;
	}

	public boolean isNotVisited() {
		return weight != 0;
	}

	public long getWeight() {
		return weight;
	}

	public void addWeight(long weight) {
		this.weight = this.weight + weight;
	}

	public void addNode(Node node) {
		linkedNodes.put(node, 0);
	}
}