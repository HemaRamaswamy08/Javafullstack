package musicplayer.service;

import java.util.ArrayList;
import java.util.Iterator;

import musicplayer.controller.MusicPlayer;
import musicplayer.exception.InvalidMovieIdException;
import musicplayer.exception.NoSongsAvailableException;

public class MusicServiceImplmentation implements MusicServices {

	ArrayList<MusicPlayer> music = new ArrayList<MusicPlayer>();

	public void create(MusicPlayer song) {
		for (MusicPlayer musicPlayer : music) {
			if (musicPlayer.getId() == song.getId()) {
				System.out.println("Song already presentS");
				return;
			}
		}
		music.add(song);
		System.out.println("Song added sucessfully");

	}

	public void display() throws NoSongsAvailableException {
		if (music.size() == 0) {
			throw new NoSongsAvailableException("Your List is Empty");
		}
		Iterator<MusicPlayer> song = music.iterator();
		while (song.hasNext()) {
			MusicPlayer current = song.next();
			System.out.println(current);
		}
	}

	public void update(int id, String movieName) throws InvalidMovieIdException, NoSongsAvailableException {
		if (music.size() == 0) {
			throw new NoSongsAvailableException("Your list is empty Please store ");
		}
		for (MusicPlayer musicPlayer : music) {
			if (id == musicPlayer.getId()) {
				musicPlayer.setMovieName(movieName);
				System.out.println("Movie name updated");
				return;
			}

		}
		throw new InvalidMovieIdException("This Movie is not present in your List to update");

	}

	public void delete(int id) throws NoSongsAvailableException {
		if (music.size() == 0) {
			throw new NoSongsAvailableException("There is Nothing in your List to delete");
		}
		for (MusicPlayer musicPlayer : music) {
			if (id == musicPlayer.getId()) {
				music.remove(musicPlayer);
				System.out.println("Deleted sucessfully");
				return;
			}
		}
		System.out.println("No Item found");
	}

	public void search(String name) throws NoSongsAvailableException {
		if (music.size() == 0) {
			throw new NoSongsAvailableException("There is Nothing in your List to delete");
		}
		for (MusicPlayer musicPlayer : music) {
			if (musicPlayer.getName().contains(name) || musicPlayer.getMovieName().contains(name)) {
				System.out.println(musicPlayer);
				return;
			}
		}
		System.out.println("No Results found");

	}

}
