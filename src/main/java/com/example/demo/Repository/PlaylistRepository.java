package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Playlist;
import com.example.demo.Entities.Song;

public interface PlaylistRepository  extends JpaRepository<Playlist, Integer>{

	

	

}
