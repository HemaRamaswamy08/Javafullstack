package com.dyashin.springmvc.service;

import java.sql.SQLException;
import java.util.List;

import com.dyashin.springmvc.model.Music;

public interface MusicService {

	Music getSongById(int id) throws SQLException;

	void addSong(Music music);

	Music deleteSong(int id);

	List<Music> getAllSong();

	boolean updateSong(Music song);
	
	Music getSong(int id);

}
