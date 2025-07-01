package day5.assesments.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shopping implements Comparable<Shopping>{
	
	public String size;
	public int quantity;
	
	public Shopping(String size, int quantity) {
		this.size = size;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Shopping o) {
		
		return this.quantity-o.quantity;
	}
	
	public static void main(String[] args) {
		List <Shopping> li = new ArrayList<>();
		li.add(new Shopping("Xs", 10));
		li.add(new Shopping("X", 20));
		li.add(new Shopping("M", 35));
		li.add(new Shopping("XL", 15));
		li.add(new Shopping("XXL", 10));
		
		Collections.sort(li);
		
		for(Shopping s : li) {
			System.out.println(s.size + " " + s.quantity);
		}
	}

}
