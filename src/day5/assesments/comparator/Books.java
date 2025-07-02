package day5.assesments.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Books implements Comparator<Books> {

	private String name;
	private String author;
	private int price;
	
	public Books() {
		
	}

	public Books(String name, String author, int price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return this.name + "-" + this.author + "-"+ this.price ;
	}

	@Override
	public int compare(Books o1, Books o2) {
		return o1.price - o2.price;
	}
	
	public static void main(String[] args) {
		
		List <Books> li = new ArrayList<>();
		li.add(new Books("Love", "hate",999));
		li.add(new Books("Hate","Love",899));
		li.add(new Books("rival","friend",1000));
		
		Collections.sort(li, new Books() );
		System.out.println(li);
		
	}

}
