package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entities.Playlist;
import com.example.demo.Entities.Song;
import com.example.demo.Service.PlaylistService;
import com.example.demo.Service.SongService;

@Controller

public class PlaylistController {
	
	@Autowired
	SongService ss;
	@Autowired
	PlaylistService ps;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model)
	{
		List<Song> songList = ss.viewSong();
		model.addAttribute("songs", songList);
		
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist ) {
		
		ps.addPlaylist(playlist);
		List<Song> songs=playlist.getSongs();		
		for(Song s:songs)
		{
			s.getPlaylists().add(playlist);
			ss.updateSong(s);
			
		}
		
		return "adminHome";
		
	}
	@GetMapping("/displayplaylist")
	public String displayplaylist(Model model)
	{
		List<Playlist> playlist=ps.fetchAllPlaylist();
		
		model.addAttribute("playlist", playlist);
		
		return "displayplaylist";
	}
	
	
	
}
