package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Song;
import com.example.demo.Repository.SongRepository;

@Service
public class SongServiceImplimentation  implements SongService{
	
	@Autowired
	SongRepository sr;
	@Override
	public void addSong(Song song) {
		sr.save(song);
		
	}
	@Override
	public List<Song> viewSong() {
		
		return sr.findAll();
	}
	@Override
	public boolean songName(String name) {
		
		Song song=sr.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public void updateSong(Song song) {
		sr.save(song);
	}
	
	

}
