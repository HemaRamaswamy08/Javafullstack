package com.dyashin.smsspb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dyashin.smsspb.model.MusicPLayer;

public interface MusicPlayerRepository extends JpaRepository<MusicPLayer, Integer> {

	@Query("Select s from MusicPLayer s where Lower(s.songName) like Lower(Concat('%' ,:keyword , '%')) OR  Lower(s.singer) like Lower(Concat('%' ,:keyword ,'%' )) OR Lower(s.movieOrAlbumName) Like Lower(Concat('%',:keyword,'%'))")
	List<MusicPLayer> searchAllSongs(String keyword);
	
	// In your repository interface
	@Query("Select s from MusicPLayer s where Lower(s.singer) like LOwer(concat('%', :singer,'%'))")
	List<MusicPLayer> findBySingerIgnoreCase (String singer);

}
