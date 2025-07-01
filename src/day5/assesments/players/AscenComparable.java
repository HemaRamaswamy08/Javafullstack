package day5.assesments.players;

import java.util.Comparator;

public class AscenComparable implements Comparator<Players>{

	@Override
	public int compare(Players o1, Players o2) {
		return o1.ranking - o2.ranking;
	}

}
