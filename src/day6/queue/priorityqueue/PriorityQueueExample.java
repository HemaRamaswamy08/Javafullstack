package day6.queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pri= new PriorityQueue<Integer>();
		pri.offer(29);
		pri.offer(99);
		pri.offer(26);
		pri.offer(102);
		pri.offer(78);
		pri.offer(289);
		
		System.out.println(pri);
		/*  
		 * peek() - > return the top element but does not remove it
		 * poll()-> return the top element and removes it from queue remove it
		 * remove(number)->if present remove it and return true
		*/
		System.out.println(pri.peek());
		System.out.println(pri.remove(100));
		System.out.println(pri.poll());
		System.out.println(pri);
	}

}
