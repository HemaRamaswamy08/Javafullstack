package collections.set.tree;

import java.util.TreeSet;

public class Fruits {

	public static void main(String[] args) {

		/*
		 * // --Works fine because String method implements the Comparable interface--
		 * TreeSet<String> fruits = new TreeSet<>(); fruits.add("apple");
		 * fruits.add("Banana"); fruits.add("Cheeku"); fruits.add("Watermelon");
		 * fruits.add("orange"); fruits.add("grapes"); System.out.println(fruits);
		 */

		/*
		 * for this we need to extend Comparable interface to FruitClass and Override
		 * CompareTo method is compulsory Because TreeSet by default follow the natural
		 * ordering it means that it will compare all the values and then store it
		 */

		TreeSet<FruitsClass> fruits = new TreeSet<FruitsClass>();
		fruits.add(new FruitsClass("apple"));
		fruits.add(new FruitsClass("papaya"));
		fruits.add(new FruitsClass("banana"));

		System.out.println(fruits);

	}

}
