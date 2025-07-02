package practice;

import java.util.LinkedList;
import java.util.ListIterator;

import util.UserInput;

public class PalindromeList {

	public static void main(String[] args) {

		boolean isPalindrome = true;
		String value = UserInput.getuserInputString("value to check palindrome");
		LinkedList<Character> li = new LinkedList<Character>();
		for (Character character : value.toCharArray()) {
			li.add(character);

		}

		ListIterator<Character> frontItr = li.listIterator(); // by default points index 0
		ListIterator<Character> backItr = li.listIterator(li.size());// points to last element

		while (frontItr.hasNext() && backItr.hasPrevious()) {
			Character first = frontItr.next();
			Character last = backItr.previous();
			if (first != last) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.println("Yes it palindrome");
		} else {
			System.out.println("It is not a palindrome");
		}

	}

}
