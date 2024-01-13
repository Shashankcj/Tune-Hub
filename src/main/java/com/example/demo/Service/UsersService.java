package com.example.demo.Service;

import com.example.demo.Entities.Users;

public interface UsersService {

	public String addInput(Users user);
	public boolean emailExist(String email);
	public boolean validate(String email,String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
	

}
