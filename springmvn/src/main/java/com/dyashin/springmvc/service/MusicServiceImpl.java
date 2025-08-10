package com.dyashin.springmvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springmvc.dao.MusicDAO;
import com.dyashin.springmvc.model.Music;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	// @Qualifier("Jdbc")
	private MusicDAO dao;

	@Override
	public Music getSongById(int id) throws SQLException {

		return dao.searchMusicById(id);
	}

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
	public boolean updateSong(Music song) {
		System.out.println("Entered Service");
		return dao.updateSong(song);
	}

	@Override
	public Music getSong(int id) {
		return dao.getSongById(id);
	}

}
