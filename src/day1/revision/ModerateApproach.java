package day1.revision;

import util.UserInput;

public class ModerateApproach implements Calculator {
	
	public int getFirstInput() {
		int a = UserInput.getuserInputInt("num");
		return a;
	}
	
	public int getSecondInput() {
		int a = UserInput.getuserInputInt("num");
		return a;
	}
	

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double div(double a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

	@Override
	public int remailder(int a, int b) {
		// TODO Auto-generated method stub
		return a%b;
	}

	

}
