package com.study.javaalgorithm.priorityqueue;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

	@Test
	public void createDefaultPriorityQueueTest() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(4);
		priorityQueue.add(3);
		priorityQueue.add(7);
		priorityQueue.add(2);

		assertThat(priorityQueue.poll()).isEqualTo(2);
		assertThat(priorityQueue.poll()).isEqualTo(3);
		assertThat(priorityQueue.poll()).isEqualTo(4);
		assertThat(priorityQueue.poll()).isEqualTo(7);
	}

	@Test
	public void createReversePriorityQueueTest() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		priorityQueue.add(4);
		priorityQueue.add(3);
		priorityQueue.add(7);
		priorityQueue.add(2);

		assertThat(priorityQueue.peek()).isEqualTo(7);
	}


	@Test
	public void createNodePriorityQueueTest() {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val - o2.val;
			}
		});

		priorityQueue.add(new Node(2));
		priorityQueue.add(new Node(3));
		priorityQueue.add(new Node(7));
		priorityQueue.add(new Node(4));

		Node dummyHead = new Node();
		Node currentNode = dummyHead;

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();
			System.out.println("node = " + node.val);

			if (node.next != null) {
				System.out.println(" -> node.next != null");
				priorityQueue.add(node.next);
			}
			currentNode.next = node;
			currentNode = currentNode.next;
		}


		assertThat(dummyHead.next.val).isEqualTo(2);
	}
}
