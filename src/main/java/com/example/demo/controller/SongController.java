package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entities.Song;
import com.example.demo.Service.SongService;


@Controller
public class SongController {
	@Autowired
	SongService ss;
	
	@PostMapping("/addsong")
	public String addSong(Song song)
	{
		boolean statusExist=ss.songName(song.getName());
		if(statusExist==false)
		{
			ss.addSong(song);
			return "adminHome";
		}
		else
		{
			return"login";
		}
		
	}
	
	@GetMapping("/viewsong")
	public String viewSong(Model model) {
		List<Song> songlist=ss.viewSong();
		
		model.addAttribute("songs", songlist);
		return "displaysongs";
	}
	
	
	@GetMapping("/playsong")
	public String playSong(Model model) {
		
		boolean primiumUser=false;
		if(primiumUser==true)
		{
		List<Song> songlist=ss.viewSong();
		
		model.addAttribute("songs", songlist);
		return "displaysongs";
		}
		
		else
		{
			return "payment";
		}
	}
	
	
	

}
