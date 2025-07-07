package day6.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		Queue<Integer> pri = new PriorityQueue<Integer>();
		pri.add(10);
		pri.add(20);
		System.out.println(pri);
		pri.offer(30); // add element at tail --> throw error if queue is full(use with ArrayBlockingQueue to fix queue)
		pri.add(60); // add element at tail(rear) --> return false if queue is full
		System.out.println(pri);
		PriorityQueue<Integer> pq = new PriorityQueue<>(12);
		for (int i = 0; i < 13; i++) {
			pq.add(i);
		}
		System.out.println(pq);
	
	}

}
