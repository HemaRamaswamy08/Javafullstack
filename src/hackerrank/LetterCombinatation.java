package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class LetterCombinatation {

	public List<String> letterCombinations(String digits) {
		List<String> comb = new ArrayList<String>();
		HashMap<Integer, String> hsh = new LinkedHashMap<Integer, String>();
		List<String> result = new ArrayList<String>();
		hsh.put(2, "abc");
		hsh.put(3, "def");
		hsh.put(4, "ghi");
		hsh.put(5, "jkl");
		hsh.put(6, "mno");
		hsh.put(7, "pqrs");
		hsh.put(8, "tuv");
		hsh.put(9, "wxyz");
		
		int num = Integer.parseInt(digits);
		while(num % 10 !=0) {
			int rem = num %10;
			String word = hsh.get(rem);
			comb.add(word);
			num = num/10;
		}
		for(int i=0; i < comb.size()-1; i++) {
			for(int j=i+1; j<comb.size(); j++) {
				String first = comb.get(i);
				String second = comb.get(j);
				
				for(char c1 : first.toCharArray()) {
					for(char c2  : second.toCharArray()) {
						result.add(""+c1+c2);
					}
				}
			}
		}
	
		
		return result;

	}

	public static void main(String[] args) {
		
		LetterCombinatation  ltr = new LetterCombinatation();
		System.out.println(ltr.letterCombinations("2"));;

	}

}
