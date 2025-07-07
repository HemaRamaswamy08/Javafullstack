package musicplayer.service;

import musicplayer.controller.MusicPlayer;
import musicplayer.exception.DigitsNotAllowedException;
import musicplayer.exception.InvalidMovieIdException;
import musicplayer.exception.NoSongsAvailableException;

public interface MusicServices {

	void create(MusicPlayer song) throws DigitsNotAllowedException;

	void display() throws NoSongsAvailableException;

	void update(int id, String movieName) throws InvalidMovieIdException, NoSongsAvailableException;

	void delete(int id) throws NoSongsAvailableException;

	void search(String name) throws NoSongsAvailableException;

}
