package com.dyashin.springboot.dao;

import java.sql.SQLException;
import java.util.List;

import com.dyashin.springboot.model.Music;

public interface MusicDAO {

	Music searchMusicById(int id) throws SQLException;

	void addSongDetails(Music music);

	Music deleteMusic(int id);

	List<Music> allSongsDisplay();

	boolean updateSong(int id , Music song);

	Music getSongById(int id);
}
