package logicalquestions;

import java.util.HashSet;

public class LongestSubString {
	public static void main(String[] args) {

		String s = "aabcbaabcdefabc";

		HashSet<Character> letters = new HashSet<>();
		int len = s.length();
		if (len == 0 || len == 1) {
			System.out.println("Longest stubtring :" + len);
			return;
		}
		int left = 0;
		int maxLength = 0;
		for (int right = 0; right < len; right++) {
			while (letters.contains(s.charAt(right))) {
				letters.remove(s.charAt(right));
				left++;
			}
			letters.add(s.charAt(left));
			maxLength = Math.max(maxLength, right - left + 1);
		}

		System.out.println(maxLength);

	}

}
