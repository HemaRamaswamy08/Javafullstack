package day6.queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorityGeeks {

	public static void main(String[] args) {

		PriorityQueue<Integer> pri = new PriorityQueue<Integer>();
		pri.add(10);
		pri.add(26);
		pri.add(87);
		pri.add(76);

		pri.add(65);
		pri.add(36);
//		System.out.println(pri);
//		System.out.println(pri.peek()); // return the top element
//		System.out.println(pri.poll()); // return & remove the top element 
//		System.out.println(pri);
		System.out.println(pri);
		System.out.println(pri.size());
		int a = pri.size();
		for (int i = 0; i < a; i++) {
			System.out.println(pri.poll());

		}

	}

}
