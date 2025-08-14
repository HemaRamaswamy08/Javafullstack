package com.dyashin.springboot.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dyashin.springboot.model.Music;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

//@Repository("Jpa")
@Primary
public class MusicDAOImpl implements MusicDAO {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

	@Override
	public Music searchMusicById(int id) {
		EntityManager manager = emf.createEntityManager();
		Music music = manager.find(Music.class, id);
		manager.close();
		System.out.println(music);
		System.out.println("JPA");
		return music;
	}

	@Override
	public void addSongDetails(Music music) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Music info = new Music();
		info.setMusicId(music.getMusicId());
		info.setSongName(music.getSongName());
		info.setMovieName(music.getMovieName());
		info.setMovieYear(music.getMovieYear());
		transaction.begin();
		manager.persist(info);
		System.out.println("Student Record inserted sucessfully");
		transaction.commit();
		manager.close();

	}

	public Music deleteMusic(int id) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Music song = manager.find(Music.class, id); // may return null
		if (song == null) {
			return null; // nothing to delete
		}

		transaction.begin();
		manager.remove(song);
		transaction.commit();
		return song;
	}

	public List<Music> allSongsDisplay() {
		EntityManager manager = emf.createEntityManager();
//		String jpql = "select s from Music s";
		TypedQuery<Music> record = manager.createNamedQuery("mus", Music.class);

		List<Music> listSongs = record.getResultList();
		System.out.println("Entered DAO");
		manager.close();

		return listSongs;

	}

	public boolean updateSong(int id , Music songInfo) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Music song = manager.find(Music.class, id);
		boolean isUpdated = false;
		transaction.begin();
		if (song != null) {
			if (songInfo.getMovieName() != null && !songInfo.getMovieName().isEmpty()) {
				song.setMovieName(songInfo.getMovieName());
			}
			if (songInfo.getSongName() != null && !songInfo.getSongName().isEmpty()) {
				song.setSongName(songInfo.getSongName());
			}
			if (songInfo.getMovieYear() != 0) {
				song.setMovieYear(songInfo.getMovieYear());
			}
			isUpdated = true;
			System.out.println("updated");
		}
		transaction.commit();
		manager.close();
		return isUpdated;

	}

	public Music getSongById(int id) {
		EntityManager manager = emf.createEntityManager();
		Music song = manager.find(Music.class, id);
		manager.close();
		return song;
	}

}