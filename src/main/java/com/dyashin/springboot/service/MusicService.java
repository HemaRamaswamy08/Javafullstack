package com.dyashin.springboot.service;

import java.sql.SQLException;
import java.util.List;

import com.dyashin.springboot.model.Music;

public interface MusicService {


	void addSong(Music music);

	Music deleteSong(int id);

	List<Music> getAllSong();

	boolean updateSong(int id ,Music song);
	
	Music getSong(int id);

}
