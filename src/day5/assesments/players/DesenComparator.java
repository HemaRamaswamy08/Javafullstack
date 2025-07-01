package day5.assesments.players;

import java.util.Comparator;

public class DesenComparator implements Comparator<Players> {

	@Override
	public int compare(Players a, Players b) {
		return b.ranking - a.ranking;
	}

}
