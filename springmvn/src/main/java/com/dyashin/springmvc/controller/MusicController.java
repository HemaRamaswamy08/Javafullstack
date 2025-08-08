package com.dyashin.springmvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dyashin.springmvc.model.Music;
import com.dyashin.springmvc.service.MusicService;

@Controller
@RequestMapping("/music")
public class MusicController {

	@Autowired
	MusicService service;

	@GetMapping("/searchSongForm")
	public String displaySearchForm() {
		return "searchSong";
	}

	@GetMapping("/search")
	public String getSongDetails(@RequestParam(name = "musicId", required = false) Integer musicId, Model model) {
		if (musicId != null) {
			Music music;
			try {
				music = service.getSongById(musicId);
				model.addAttribute("music", music);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			model.addAttribute("error");
		}

		return "searchSong";
	}

	@GetMapping("/adding")
	public String adding() {
		return "addSong";
	}

	@PostMapping("/add")
	public String addSongDetails(@ModelAttribute("song") Music song, Model map) {
		/*
		 * public String addSongDetails(HttpServletRequest req){ int movieId =
		 * Integer.parseInt(req.getParameter("musicId")); String movieName =
		 * req.getParameter("movieName"); String artist = req.getParameter("artist");
		 * int year = Integer.parseInt(req.getParameter("movieYear"));
		 * System.out.println(movieId + " " + year);
		 * 
		 * Music song = new Music(movieId, movieName, artist, year);
		 * service.addSong(song);
		 */
		service.addSong(song);
		map.addAttribute("msg", "Song added sucesfully");
		return "addSong";
	}

	@GetMapping("/delete")
	public String deleteSongDetails(@RequestParam(name = "musicId") Integer musicId, Model map) {
		Music deletedSong = service.deleteSong(musicId);
		map.addAttribute("deletedSong", deletedSong);
		return "deleteMsg";

	}

	@GetMapping("/songs")
	public String displayAllSongs(Model model) {
		List<Music> songs = service.getAllSong();
		System.out.println("entered Controller");
		model.addAttribute("songs", songs);
		return "display";
	}

	@GetMapping("/editSong")
	public String showUpdateForm(@RequestParam("musicId") int musicId, Model model) {
		Music song = service.getSong(musicId);
		if (song != null) {
			model.addAttribute("music", song);
			return "updateSong";
		} else {
			model.addAttribute("msg", "Song Not Found");
			return "redirect:/songs";
		}

	}

	@PostMapping("/update")
	public String update(@ModelAttribute("music") Music song, Model model) {
		boolean isUpdated = service.updateSong(song);
		if (isUpdated) {
			model.addAttribute("msg", "Updated successfully");
		} else {
			model.addAttribute("msg", "Updated Failed");
		}
		model.addAttribute("music", song);
		return "updateSong";

	}

}
