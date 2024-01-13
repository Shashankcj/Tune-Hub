package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylist();

}
