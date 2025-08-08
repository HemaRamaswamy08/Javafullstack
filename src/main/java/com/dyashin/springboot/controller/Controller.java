package com.dyashin.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.springboot.model.Music;
import com.dyashin.springboot.model.UserResponse;
import com.dyashin.springboot.service.MusicService;

//@org.springframework.stereotype.Controller
@RestController
public class Controller {
	/*
	 * UserResponse musicDetails = new UserResponse(); Instead of creating this we
	 * can make use of ResponseEnitity
	 */
	@Autowired
	MusicService service;
	

	@GetMapping("/search/{musicId}")
	// @ResponseBody
	public ResponseEntity<Music> searchById(@PathVariable(name = "musicId") int musicId) {
		// UserResponse musicDetails = new UserResponse();
		ResponseEntity<Music> response;
		Music music = service.getSong(musicId);
		if (music != null) {
			response= new ResponseEntity<>(HttpStatusCode.valueOf(200));
			response.ok();
			
		} else {
			response = new ResponseEntity<>(HttpStatusCode.valueOf(500));

		}

		return response;

	}

	@GetMapping("/deleteMsg")
	// @ResponseBody
	public Music deleteById(@RequestParam(name = "musicId") int musicId) {
		return service.deleteSong(musicId);
	}

	@GetMapping("/list")
	// @ResponseBody
	public List<Music> allSongs() {
		return service.getAllSong();
	}

	@PostMapping("/add")
	// @ResponseBody
	public String addSong(@RequestBody Music music) {
		UserResponse musicDetails = new UserResponse();
		service.addSong(music);
		return "sucess";

	}

	@PutMapping("/update/{musicId}")
	public UserResponse update(@PathVariable(name = "musicId") int musicId, @RequestBody Music music) {
		UserResponse musicDetails = new UserResponse();
		boolean isUpdated = service.updateSong(musicId, music);
		if (isUpdated) {
			musicDetails.setStatusCode(200);
			musicDetails.setMsg("Sucess");
			musicDetails.setDescription("Updated by id");
			musicDetails.setBeans(Arrays.asList(music));

		} else {
			musicDetails.setStatusCode(404);
			musicDetails.setMsg("Failure");
			musicDetails.setDescription("Updated by id");

		}

		return musicDetails;
	}

}
