package day7.map.hashmap;

import java.util.HashMap;

public class HashMapFirst {

	public static void main(String[] args) {

		HashMap<Integer, String> data = new HashMap<Integer, String>();
		data.put(5, "rose");
		data.put(1, "hema");
		data.put(2, "nisha");
		data.put(3, "resh");
		System.out.println(data);

		System.out.println(data.get(1));

		System.out.println(data.keySet());

	}

}
