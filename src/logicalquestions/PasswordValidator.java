package logicalquestions;

public class PasswordValidator {

	public static boolean isValid(String str) {
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasNumber = false;
		boolean hasSpecialChar = false;

		if (str.length() < 8) {
			return false;
		}
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch))
				hasUpper = true;
			if (Character.isLowerCase(ch))
				hasLower = true;
			if (Character.isDigit(ch))
				hasNumber = true;
			if (!Character.isLetterOrDigit(ch))
				hasSpecialChar = true;

			if (hasLower && hasUpper && hasNumber && hasSpecialChar) {
				return true;
			}

		}
		return false;

	}

	public static void main(String[] args) {

		String password = "Hema@2025";
		boolean result = PasswordValidator.isValid(password);
		if (result) {
			System.out.println("Yes valid password");
		} else {
			System.out.println("Not a valid password");
		}

	}

}
