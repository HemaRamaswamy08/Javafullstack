package com.dyashin.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dyashin.springmvc.model.Music;
import com.dyashin.springmvc.util.DBConnection;

/*i have 2 different implementation for 1 interface so explicitly mentioning the name */
@Repository("Jdbc")
public class MusicDAOImplJdbc implements MusicDAO {

	@Autowired
	DBConnection dBConnection;

	@Override
	public Music searchMusicById(int id) throws SQLException {
		String query = "select * from musicplayer where music_id = ?";
		try (Connection connection = dBConnection.getDBConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {

			stmt.setInt(1, id);
			try (ResultSet res = stmt.executeQuery()) {
				if (res.next()) {
					System.out.println("JDBC Implementation");
					int movieId = res.getInt("music_Id");
					String songName = res.getString("song_name");
					String movieName = res.getString("movie_name");
					int year = res.getInt("movie_year");
					return new Music(movieId, songName, movieName, year);

				}
			}

			return null;

		}
	}

	@Override
	public void addSongDetails(Music music) {
		// TODO Auto-generated method stub

	}

	@Override
	public Music deleteMusic(int id) {
		return null;
	}

	@Override
	public List<Music> allSongsDisplay() {
		System.out.println("Ullas Toothpaste");
		return null;
	}

	@Override
	public boolean updateSong(Music song) {
		return false;
	}

	@Override
	public Music getSongById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
