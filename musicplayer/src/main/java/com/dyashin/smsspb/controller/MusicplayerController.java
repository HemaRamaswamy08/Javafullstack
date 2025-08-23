package com.dyashin.smsspb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.smsspb.service.MUsicPlayerService;
import com.dyashin.smsspb.util.MusicInfo;

@RestController
@RequestMapping("/musicplayer")
public class MusicplayerController {

	@Autowired
	MUsicPlayerService service;

	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addSong(@RequestBody MusicInfo music) {
		Map<String, Object> response = new HashMap<>();
		service.addSong(music);
		response.put("message", "Added Sucessfully");
		response.put("status", HttpStatus.OK);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllSong() {
		List<MusicInfo> allSongs = service.getAllSong();
		Map<String, Object> response = new HashMap<>();

		if (allSongs.isEmpty()) {
			response.put("message", "No Data Found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			response.put("message", "Data Retreived sucesfully");
			response.put("data", allSongs);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateMusic(@RequestBody MusicInfo music) {
		boolean isUpdated = service.updateSongById(music);
		Map<String, Object> response = new HashMap<>();
		if (isUpdated) {
			response.put("message", "updated sucesfully");
			response.put("data", service.getSongById(music.getMusicId()));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("message", "Update Failed");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable int id) {
		boolean isDeletd = service.deleteSongByID(id);
		Map<String, Object> response = new HashMap<>();
		if (isDeletd) {
			response.put("message", "Deleted sucesfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("message", "Song with Id " + id + " not found or could not be deleted.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/searchbyId/{id}")
	public ResponseEntity<Map<String, Object>> searchById(@PathVariable int id) {
		MusicInfo music = service.getSongById(id);
		Map<String, Object> response = new HashMap<>();

		if (music != null) {
			response.put("message", "Data Retreived sucesfully");
			response.put("data", music);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("message", "ID is not prsenst");
			response.put("data", music);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@GetMapping("/searchBySingerName/{name}")
	public ResponseEntity<Map<String, Object>> searchBySongName(@PathVariable String name) {
		List<MusicInfo> music = service.getSongBySinger(name);
		Map<String, Object> response = new HashMap<>();
		if (! music.isEmpty()) {
	        response.put("message", "Data retrieved successfully");
	        response.put("data", music);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        response.put("message", "No song found for singer: " + name);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<Map<String, Object>> search(@PathVariable String keyword) {
		List<MusicInfo> allSongs = service.searchAllSongs(keyword);
		Map<String, Object> response = new HashMap<>();

		if (allSongs.isEmpty()) {
			response.put("message", "No Data Found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			response.put("message", "Data Retreived sucesfully");
			response.put("data", allSongs);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	

}
