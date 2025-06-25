package day2;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {

		String name = "hema is a good girl h";
		char[] letters = name.toCharArray();
		boolean found = false;
		for (int i = 0; i < letters.length; i++) {
			boolean isUnique = true;
			for (int j = 0; j < letters.length; j++) {
				if (i != j && letters[i] == letters[j]) {
					isUnique = false;
					break;
				}

			}
			if (isUnique) {
				System.out.println("First Non Repeating character :" + letters[i]);
				break;

			}

		}

	}

}
