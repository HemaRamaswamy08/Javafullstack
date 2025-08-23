package com.dyashin.smsspb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MusicPLayer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int musicId;

	private String songName;
	private String singer;
	private String movieOrAlbumName;

}
