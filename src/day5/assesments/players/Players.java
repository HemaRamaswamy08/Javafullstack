package day5.assesments.players;

import java.util.ArrayList;
import java.util.TreeSet;

public class Players {

	public String name;
	public int age;
	public int ranking;

	public Players(String name, int age, int ranking) {
		this.name = name;
		this.age = age;
		this.ranking = ranking;
	}

	public String toString() {
		return name + " " + ranking;
	}

	public static <E> void main(String[] args) {
		Players player1 = new Players("Hema", 21, 1);

		TreeSet<Players> ascendingRanking = new TreeSet<>(new AscenComparable());
		ascendingRanking.add(player1);
		ascendingRanking.add(new Players("Raty", 23, 23));
		ascendingRanking.add(new Players("manvith", 27, 99));
		ascendingRanking.add(new Players("Sandeep", 28, 10));
		ascendingRanking.add(new Players("Moon", 23, 5));
		ascendingRanking.add(new Players("Pretham", 24, 16));
		ascendingRanking.add(new Players("Nisha", 22, 2));
		ascendingRanking.add(new Players("Sam", 23, 76));
		ascendingRanking.add(new Players("Whitey", 21, 89));
		ascendingRanking.add(new Players("Resh", 21, 20));
		ascendingRanking.add(new Players("Pooja", 25, 68));

		System.out.println("Ascending Order Based on Ranking -");
		System.out.println(ascendingRanking);
		
		TreeSet<Players> descendingRanking = new TreeSet<>(new DesenComparator());
		descendingRanking.add(player1);
		descendingRanking.add(new Players("Raty", 23, 23));
		descendingRanking.add(new Players("manvith", 27, 99));
		descendingRanking.add(new Players("Sandeep", 28, 10));
		descendingRanking.add(new Players("Moon", 23, 5));
		descendingRanking.add(new Players("Pretham", 24, 16));
		descendingRanking.add(new Players("Nisha", 22, 2));
		descendingRanking.add(new Players("Sam", 23, 76));
		descendingRanking.add(new Players("Whitey", 21, 89));
		descendingRanking.add(new Players("Resh", 21, 20));
		descendingRanking.add(new Players("Pooja", 25, 68));
		descendingRanking.add(new Players("Raty", 23, 23));
		descendingRanking.add(new Players("manvith", 27, 99));
		descendingRanking.add(new Players("Sandeep", 28, 10));
		descendingRanking.add(new Players("Moon", 23, 5));
		descendingRanking.add(new Players("Pretham", 24, 16));
		descendingRanking.add(new Players("Nisha", 22, 2));
		
		System.out.println("Descending Order Based on Ranking -");
		System.out.println(descendingRanking);
		
		ArrayList< Players> arr = new ArrayList<Players>();

	}

}
