package day2;

public class FindOneExtra{
	public static void main(String[] args) {
		
		String one = "abcd";
		String two = "bcdea";
		
		int [] charCounts = new int[256];
		char res = '0';
		for(char c : one.toCharArray()) {
			charCounts[c]++;
		}
		for(char c : two.toCharArray()) {
			charCounts[c]--;
		}
		for(int i=0; i<charCounts.length; i++) {
			if(charCounts[i] <0) {
				res = (char) i;
			}
		}
		System.out.println(res);
		
	}

}
