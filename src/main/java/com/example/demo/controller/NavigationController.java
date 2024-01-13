package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	@GetMapping("/login")
	public String login()
	{
		
		return "login";
	}

	@GetMapping("/registor")
	public String registor()
	{
		
		return "registor";
	}
	@GetMapping("/newsong")
	public String newSong()
	{
		return "newsong";
	}
}
