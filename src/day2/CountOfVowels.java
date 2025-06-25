package day2;

public class CountOfVowels {

	public static void main(String[] args) {

		String sentence = "Java is a Programmin language";
		String[] letters = sentence.split("");
		int count = 0;
		int blank =0;
		for (int i = 0; i < letters.length; i++) {
			String letter = letters[i];
			if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i")
					|| letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) {
				count++;
			}
			if(letter.isBlank()) {
				blank++;
			}
		}
		System.out.println("Count of vowels "+ count);
		System.out.println("Count of Constants "+ (sentence.length()-blank-count));
	}

}
