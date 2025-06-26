package day2.stringproblems;

public class Anagram {

	public static void main(String[] args) {
		String wordOne = "silent";
		String wordTwo = "listen";

		boolean isAnagram = true;

		if (wordOne.length() != wordOne.length()) {
			isAnagram = false;
		}

		int[] alphabets = new int[26];

		for (int i = 0; i < wordOne.length(); i++) {
			alphabets[wordOne.charAt(i) - 'a']++;
		}

		for (int i = 0; i < wordTwo.length(); i++) {
			alphabets[wordTwo.charAt(i) - 'a']--;
		}

		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] != 0) {
				isAnagram = false;
			}
		}
		if (isAnagram) {
			System.out.println("Yes it a Anagram");
		} else {
			System.out.println("No it is not a Anagram ");
		}

	}

}
