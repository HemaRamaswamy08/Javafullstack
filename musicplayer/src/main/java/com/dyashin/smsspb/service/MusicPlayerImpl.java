package com.dyashin.smsspb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.smsspb.exception.ResourceNotFoundException;
import com.dyashin.smsspb.model.MusicPLayer;
import com.dyashin.smsspb.repo.MusicPlayerRepository;
import com.dyashin.smsspb.util.MusicInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MusicPlayerImpl implements MUsicPlayerService {

	// Logger logger = LoggerFactory.getLogger(MusicPlayerImpl.class);

	// @Autowired
	// Logger logger;

	@Autowired
	MusicPlayerRepository repo;

	@Override
	public List<MusicInfo> getAllSong() {
		return repo.findAll().stream().map(song -> {
			MusicInfo music = new MusicInfo();
			BeanUtils.copyProperties(song, music);
			return music;
		}).collect(Collectors.toList());
	}

	@Override
	public MusicInfo getSongById(int id) {
		MusicPLayer song = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Song with Id " + id + " doesn't found"));
		MusicInfo music = new MusicInfo();
		BeanUtils.copyProperties(song, music);
		return music;
	}

	@Override
	public List<MusicInfo> getSongBySinger(String singerName) {
		List<MusicPLayer> all = repo.findBySingerIgnoreCase(singerName);
		if (all.isEmpty()) {
			return List.of();
		}

		return all.stream().map(song -> {
			MusicInfo music = new MusicInfo();
			BeanUtils.copyProperties(song, music);
			return music;
		}).collect(Collectors.toList());

	}

	@Override
	public void addSong(MusicInfo music) {
		MusicPLayer song = new MusicPLayer();
		BeanUtils.copyProperties(music, song);
		repo.save(song);

	}

	@Override
	public boolean deleteSongByID(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSongById(MusicInfo music) {
		if (repo.existsById(music.getMusicId())) {
			log.info("music with Id " + music.getMusicId() + " is found");
			MusicPLayer song = repo.findById(music.getMusicId()).get();
			if (music.getMovieOrAlbumName() != null) {
				song.setMovieOrAlbumName(music.getMovieOrAlbumName());
			}
			if (music.getSinger() != null) {
				song.setSinger(music.getSinger());
			}
			if (music.getSongName() != null) {
				song.setSongName(music.getSongName());
			}
			repo.save(song);
			return true;
		}
		log.warn("failed to update");
		return false;
	}

	@Override
	public List<MusicInfo> searchAllSongs(String keyword) {
		List<MusicPLayer> allSongs = repo.searchAllSongs(keyword);
		return allSongs.stream().map(music -> {
			MusicInfo song = new MusicInfo();
			BeanUtils.copyProperties(music, song);
			return song;
		}).collect(Collectors.toList());

	}

}
