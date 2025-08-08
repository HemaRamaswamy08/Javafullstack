package com.dyashin.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyashin.springboot.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

}
