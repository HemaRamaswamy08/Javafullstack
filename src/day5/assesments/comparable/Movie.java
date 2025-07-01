package day5.assesments.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie implements Comparable<Movie> {
	public String name;
	public int year;

	public Movie(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public int compareTo(Movie o) {
//		return this.year - o.year; //--> Ascending order
		return o.year -this.year; //-->Descending order
	}

	public static void main(String[] args) {

		List<Movie> movie = new ArrayList<>();
		movie.add(new Movie("Mourya", 2005));
		movie.add(new Movie("Rambo", 2014));
		movie.add(new Movie("Gaja", 2004));

		Collections.sort(movie);
		System.out.println("Movies after sorting");
		for (Movie m : movie) {
			System.out.println(m.getName() + " " + m.getYear());
		}
	}

}
