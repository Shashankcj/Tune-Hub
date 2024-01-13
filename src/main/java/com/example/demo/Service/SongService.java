package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> viewSong();

	public boolean songName(String name);
	
	public void updateSong(Song song);

}
