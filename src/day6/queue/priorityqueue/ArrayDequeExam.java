package day6.queue.priorityqueue;

import java.util.ArrayDeque;

public class ArrayDequeExam {
	
	public static void main(String[] args) {
		
		ArrayDeque<String> deq = new ArrayDeque<String>();
		deq.add("hema");
		deq.add("nisha");
		deq.add("resh");
		deq.add("sam");
		/*
		 *Allows duplicate values and maintain insertion order
		 *by default removes the first element
		*/
		System.out.println(" Intial : " + deq);
		deq.add("hema");
		deq.addFirst("students");
		deq.addLast("manvith");
		System.out.println(deq);
		deq.remove();
		deq.removeLast();
		
		System.out.println(deq);
		
		
	}

}
