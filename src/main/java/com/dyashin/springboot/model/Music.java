package com.dyashin.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "musicplayer")
@AllArgsConstructor
@NoArgsConstructor // -->this is compulsory for Hibernate implementation
@NamedQuery(name = "mus", query = "select s from Music s")
public class Music {

	@Id
	@Column(name = "music_id")
	@JsonProperty
	private int musicId;

	@Column(name = "song_name")
	@JsonProperty
	private String songName;

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	@JsonProperty
	@Column(name = "movie_name")
	private String movieName;

	@JsonProperty
	@Column(name = "movie_year")
	private int movieYear;

}
