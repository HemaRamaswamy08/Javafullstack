package logicalquestions;

import java.util.ArrayList;

public class ZigZagConv {

	public static void main(String[] args) {

		String s = "PAYPALISHIRING";
		int numRows = 3;

		if (numRows == 1 || s == null) {
			System.out.println(s);
			return;
		}

		ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		int currentRow = 0;
		boolean goDown = false;

		for (char c : s.toCharArray()) {
			rows.get(currentRow).append(c);

			if (currentRow == 0 || currentRow == numRows - 1) {
				goDown = !goDown;
			}
			if (goDown) {
				currentRow++;
			} else {
				currentRow--;
			}
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder str : rows) {
			result.append(str);
		}

		System.out.println(result.toString());

	}

}
