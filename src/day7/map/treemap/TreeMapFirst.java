package day7.map.treemap;

import java.util.TreeMap;

public class TreeMapFirst {

	public static void main(String[] args) {

		TreeMap<Integer, String> data = new TreeMap<Integer, String>();
		data.put(5, "rose");
		data.put(1, "hema");
		data.put(2, "nisha");
		data.put(3, "resh");

		System.out.println(data);
		System.out.println(data.get(3));
	}
}
