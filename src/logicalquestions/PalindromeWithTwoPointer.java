package logicalquestions;



import util.UserInput;

public class PalindromeWithTwoPointer {

	public static void main(String[] args) {

		String value = UserInput.getuserInputString("value to check palindrome");
		int i = 0;
		int j = value.length() - 1;
		boolean isPalindrome = true;

		while (i < j) {
			char first = value.charAt(i);
			char last = value.charAt(j);
			if(first != last) {
				isPalindrome = false;
				break;
			}else {
				i++;
				j--;
			}
			
		}
		if(isPalindrome) {
			System.out.println("Yes it is palindrome");
		}else {
			System.out.println("Not a palindrome");
		}
	}

}
