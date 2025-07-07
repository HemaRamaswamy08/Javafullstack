package musicplayer.controller;

import java.util.InputMismatchException;

import musicplayer.exception.DigitsNotAllowedException;
import musicplayer.exception.InvalidMovieIdException;
import musicplayer.exception.NoSongsAvailableException;
import musicplayer.service.MusicServiceImplmentation;
import musicplayer.util.UserInput;

public class MusicApp {
	static MusicServiceImplmentation song = new MusicServiceImplmentation();

	public static void choice() {
		System.out.println();
		int choice = 0;
		boolean isvalid = false;
		do {
			System.out.println("1️. Add Song to Your 🩷List..");
			System.out.println("2. Edit your songs Informatation");
			System.out.println("3. To see Your 🩷List");
			System.out.println("4.To remove a song from your 🩷List");
			System.out.println("5.Search Your song");
			System.out.println("6. Exit");
			try {
				choice = UserInput.getUserInputInt("choice");
				function(choice);
				isvalid = true;
			} catch (InputMismatchException e) {
				System.err.println("An Error occured : Please enter a proper input");
				UserInput.SCANNER.next();
			}
		} while (!isvalid);

	}

	public static void function(int choice) {
		switch (choice) {
		case 1 -> {
			MusicPlayer info = songDetails();
			try {
				song.create(info);
			}catch(DigitsNotAllowedException e) {
				System.err.println("An Error Occured : " + e.getMessage() );
			}
			
			choice();
		}

		case 2 -> {
			int value = UserInput.getUserInputInt("Movie Id");
			String name = UserInput.getUserInputString(" movie name or song name to update");
			try {
				song.update(value, name);
			} catch (InvalidMovieIdException e) {
				System.err.println("An Error Occured : " + e.getMessage());
			} catch (NoSongsAvailableException e) {
				System.err.println("An error occured :" + e.getMessage());
			}
			choice();
		}
		case 3 -> {
			try {
				song.display();
			} catch (NoSongsAvailableException e) {
				System.out.println(e.getMessage());
			}
			choice();
		}

		case 4 -> {
			int movieId = UserInput.getUserInputInt("Movie Id to delete");
			try {
				song.delete(movieId);
			} catch (NoSongsAvailableException e) {
				System.err.println("An error occured : " + e.getMessage());
			}
			choice();
		}

		case 5 -> {
			try {
				String name = UserInput.getUserInputString(" Movie name or song name  to search a song");
				song.search(name);
			} catch (NoSongsAvailableException e) {
				System.out.println("Your List is empty");
			}
			choice();
		}
		case 6 -> System.out.println("THank You for Using");
		}
	}

	public static MusicPlayer songDetails() {
		int id = UserInput.getUserInputInt("Id");
		String name = UserInput.getUserInputString("Song Name");
		String movieName = UserInput.getUserInputString("Movie Name");
		int year = UserInput.getUserInputInt("year");
		return new MusicPlayer(name, id, year, movieName);
	}

}
