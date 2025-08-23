package com.dyashin.smsspb.service;

import java.util.List;

import com.dyashin.smsspb.util.MusicInfo;

public interface MUsicPlayerService {

	List<MusicInfo> getAllSong();

	MusicInfo getSongById(int id);

	void addSong(MusicInfo music);

	boolean deleteSongByID(int id);

	boolean updateSongById(MusicInfo id);

	List<MusicInfo> searchAllSongs(String keyword);

	List<MusicInfo> getSongBySinger(String singerName);
}
