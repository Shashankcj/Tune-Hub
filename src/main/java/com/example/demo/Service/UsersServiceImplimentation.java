package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Users;
import com.example.demo.Repository.UsersRepositories;
@Service
public class UsersServiceImplimentation implements UsersService{
	@Autowired
	UsersRepositories ur;
	@Override
	public String addInput(Users user) {
	
		ur.save(user);
		return "User added successfully";
	}
	@Override
	public boolean emailExist(String email) {
		if(ur.findByEmail(email)==null)
		{
			return false;
		}
		return true;
	}
	@Override
	public boolean validate(String email, String password) {
		Users user=ur.findByEmail(email);
		if(password.equals(user.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		Users user=ur.findByEmail(email);
		return user.getRole();
	}
	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateUser(Users user) {
		ur.save(user);
		
	}

}
