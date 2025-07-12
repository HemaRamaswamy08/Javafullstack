package com.org.dyashin.jdbcsession.musicplayerwithjdbc;

import exception.InputMismatchException;
import util.UserInput;

public class MusicPlayerUser {

	public static void function() {
		System.out.println();
		int choice = 0;
		do {
			System.out.println("1️. Add Song to Your 🩷List..");
			System.out.println("2. Edit your songs Informatation");
			System.out.println("3. To see Your 🩷List");
			System.out.println("4.To remove a song from your 🩷List");
			System.out.println("5.Search Your song");
			System.out.println("6. Exit");

			choice = UserInput.getuserInputInt("choice");

			switch (choice) {
			case 1 -> {
				System.out.println("Enter Song Details");
				int id = UserInput.getuserInputInt("Music Id");
				String name = UserInput.getuserInputString("Song name");
				String movieName = UserInput.getuserInputString("Movie Name");
				int year = UserInput.getuserInputInt("year");
				MusicPlayerImpl.addSong(id, name, movieName, year);
			}
			case 2 -> {
				int id = UserInput.getuserInputInt("Music Id");
				String name = UserInput.getuserInputString("Song name");
				MusicPlayerImpl.updateSong(id, name);
			}
			case 3 -> MusicPlayerImpl.display();
			case 4 -> {
				int id = UserInput.getuserInputInt("Music Id");
				MusicPlayerImpl.deleteSong(id);
			}
			case 5 -> {
				int id = UserInput.getuserInputInt("Music Id");
				MusicPlayerImpl.searchSong(id);
			}
			case 6 -> {
				System.out.println("THank You visit again");
				MusicPlayerImpl.closeConnection();
			}

			}

		} while (choice != 6);
		{
		}

	}
}
