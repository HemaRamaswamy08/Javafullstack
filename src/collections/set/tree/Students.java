package collections.set.tree;

import java.util.Comparator;

public class Students implements Comparator<Integer> {

	public Students() {

	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
