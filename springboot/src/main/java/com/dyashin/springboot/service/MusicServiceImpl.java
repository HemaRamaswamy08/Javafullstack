package com.dyashin.springboot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springboot.dao.MusicDAO;
import com.dyashin.springboot.model.Music;

//@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	// @Qualifier("Jdbc")
	private MusicDAO dao;



	@Override
	public void addSong(Music music) {
		dao.addSongDetails(music);

	}

	@Override
	public Music deleteSong(int id) {
		System.out.println("entered service");
		return dao.deleteMusic(id);
	}

	@Override
	public List<Music> getAllSong() {
		System.out.println("Entered Service");
		List<Music> list = dao.allSongsDisplay();
		return list;
	}

	@Override
	public boolean updateSong(int id, Music song) {
		System.out.println("Entered Service");
		return dao.updateSong(id, song);
	}

	@Override
	public Music getSong(int id) {
		return dao.getSongById(id);
	}

}
