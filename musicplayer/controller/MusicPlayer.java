package musicplayer.controller;

public class MusicPlayer {
	private String name;
	private int id;
	private int year;
	private String movieName;

	public MusicPlayer(String name, int id, int year, String movieName) {
		super();
		this.name = name;
		this.id = id;
		this.year = year;
		this.movieName = movieName;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public String getMovieName() {
		return movieName;
	}

	public String toString() {
		return this.id + ". " + this.name + " - " + this.movieName + " -" + this.year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
