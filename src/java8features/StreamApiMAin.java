package java8features;

import java.util.Arrays;
import java.util.List;

public class StreamApiMAin {
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(1,2,4,3,5,7,8);
		
		arr.stream().filter(n->n%2==0).forEach(System.out::println);
	}

}
