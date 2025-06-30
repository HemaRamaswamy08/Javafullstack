package logicalquestions;

import java.util.Stack;

public class BracketChecker {
	
	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch :str.toCharArray()) {
			
			switch (ch) {
			case '(': case '{' : case '[': 
				stack.push(ch);
				break;
			case ')':
				if(stack.isEmpty() ||stack.pop() != '(') return false;
				break;
			case '}':
				if(stack.isEmpty() ||stack.pop() != '{') return false;
				break;
			case ']':
				if(stack.isEmpty() ||stack.pop() != '[') return false;
				break;
			
			}
			
		}
		return stack.isEmpty();
		
	}
	public static void main(String[] args) {
		
		String str = "{}";
		boolean result = BracketChecker.isBalanced(str);
		if(result) {
			System.out.println("Yes balanced");
		}else {
			System.out.println("Not balanced");
		}
		
		
	}

}
