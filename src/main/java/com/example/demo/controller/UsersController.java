package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entities.Users;
import com.example.demo.Service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService us;
	
	@PostMapping("/registor")
	public String addInput(@ModelAttribute Users user)
	{
		
		boolean userStatus=us.emailExist(user.getEmail());
		if(userStatus==false)
		{
			 String st=us.addInput(user);
			
			 return "login";
		}
		else
		{
			return "registor";
		}
	    
	    
	}
	@PostMapping("/login")
	public String validate(@RequestParam String email,@RequestParam String password ,HttpSession session) 
	{
		if(us.validate(email,password)==true)
		{
			
			session.setAttribute("email", email);
			
			if(us.getRole(email).equals("Admin"))
			{
				return "adminHome";
			}
			else
			{
				return "customerHome";
			}
		
		}
		
		else
		{
			return "login";
		}
	}
	
	public String pay(String email)
	{
		boolean paymentStatus=false;
		if(paymentStatus==true)
		{
			Users user = us.getUser(email);
			user.setPremium(true);
			
			us.updateUser(user);
		}
		
		return "login";
	
}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
}
