package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Users;

public interface UsersRepositories extends JpaRepository<Users,Integer> {
	
	public Users findByEmail(String email);

}
