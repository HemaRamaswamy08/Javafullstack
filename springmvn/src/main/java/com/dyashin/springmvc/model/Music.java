package com.dyashin.springmvc.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "musicplayer")
@AllArgsConstructor
@NoArgsConstructor // -->this is compulsory for Hibernate implementation
@NamedQuery(name = "mus", query = "select s from Music s")
public class Music {

	@Id
	@Column(name = "music_id")
	private int musicId;
	@Column(name = "song_name")
	private String songName;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "movie_year")
	private int movieYear;

}
