package com.study.javaalgorithm.programmers.level3.정수삼각형;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int[][] triangle) {

		Node[][] tree = new Node[triangle.length][triangle[triangle.length - 1].length];

		for (int i = 0; i < triangle.length - 1; i ++) {
			int[] currentTriangle = triangle[i];
			int[] nextTriangle = triangle[i + 1];
			Node currentNode;

			for (int j = 0; j < currentTriangle.length - 1; j ++) {
				int n = currentTriangle[j];
				currentNode = new Node(n);

				if (tree[i][nextTriangle[j]] == null) {
					tree[i][nextTriangle[j]] = new Node(nextTriangle[j]);
					System.out.println("nextTriangle : " + tree[i][nextTriangle[j]]);
				}
				if (tree[i][nextTriangle[j + 1]] == null) {
					tree[i][nextTriangle[j + 1]] = new Node(nextTriangle[j + 1]);
				}

				tree[i][j].add(tree[i][nextTriangle[j]]);
				tree[i][j].add(tree[i][nextTriangle[j + 1]]);
			}

			printTree(tree);
		}

		return 1;
	}

	private void printTree(Node[][] tree) {
		for (int i = 0; i < tree.length; i ++) {
			for (int j = 0; j < tree[i].length; j++) {
				System.out.print(tree[i][j] + " ");
			}
			System.out.println();
		}
	}

	public class Node {
		private int n;
		Queue<Integer> linkedList;

		public Node(int n) {
			this.n = n;
			linkedList = new LinkedList<>();
		}

		public void add(Node linkedNode) {

		}

		@Override
		public String toString() {
			return String.valueOf(n);
		}
	}
}
