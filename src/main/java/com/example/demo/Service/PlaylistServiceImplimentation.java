package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Playlist;
import com.example.demo.Repository.PlaylistRepository;

@Service
public class PlaylistServiceImplimentation implements PlaylistService{

	@Autowired
	SongService ss;
	
	@Autowired
	PlaylistRepository pr;
	@Override
	public void addPlaylist(Playlist playlist) {
		
		pr.save(playlist);
			
	}
	@Override
	public List<Playlist> fetchAllPlaylist() {
		
		return pr.findAll();
	}

}
