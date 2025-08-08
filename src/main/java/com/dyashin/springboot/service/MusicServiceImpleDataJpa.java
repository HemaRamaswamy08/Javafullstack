package com.dyashin.springboot.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springboot.model.Music;
import com.dyashin.springboot.repository.MusicRepository;

@Service
public class MusicServiceImpleDataJpa implements MusicService {

	@Autowired
	private MusicRepository repo;

	@Override
	public Music getSong(int id) {
		Optional<Music> music = repo.findById(id);
		if (music.isPresent()) {
			return music.get();
		}
		return null;
	}

	@Override
	public void addSong(Music music) {
		// TODO Auto-generated method stub

	}

	@Override
	public Music deleteSong(int id) {
		repo.deleteById(id);

		return null;
	}

	@Override
	public List<Music> getAllSong() {
		return repo.findAll();
	}

	@Override
	public boolean updateSong(int id, Music song) {
		// TODO Auto-generated method stub
		return false;
	}

}
