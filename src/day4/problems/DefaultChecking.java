package day4.problems;

public class DefaultChecking  implements NDefaultMethods , StaticAndDefault{

	@Override
	public void dostuff() {
		System.out.println("Method One");
		
	}

	@Override
	public void dostuffOne() {
		System.out.println("Method Two");
		
	}
	
	@Override
	public void breakFast() {
		// TODO Auto-generated method stub
		NDefaultMethods.super.breakFast();
	}

	public static void main(String[] args) {
		DefaultChecking d = new DefaultChecking();
		d.breakFast();
		d.dostuff();
		d.dostuffOne();
		
		
	}

}
