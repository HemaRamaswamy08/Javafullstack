package day4;

import java.util.HashSet;

public class HashSetExam {

	public static void main(String[] args) {

		HashSet<String> family = new HashSet<>();

		family.add("hema");
		family.add("rama");
		family.add("manvith");
		family.add(null);
		family.add("veena");
		family.add("sandy");

		System.out.println(family);
	}

}
