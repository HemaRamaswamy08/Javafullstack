package day2.stringproblems;

public class ReverseWordInString{

	public static void main(String[] args) {

		String name = "hema is a good girl";
		String[] words = name.split(" ");

		String reversedSentence = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverse = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reverse += word.charAt(j);
			}
			reversedSentence += reverse + " ";
		}
		System.out.println(reversedSentence);

	}

}
