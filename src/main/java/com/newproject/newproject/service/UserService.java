package com.newproject.newproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.newproject.entity.UserEntity;
import com.newproject.newproject.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public boolean saveUser(UserEntity userEntity) 
	{
		 try 
		 {
			userRepo.save(userEntity);
			return true;
		 } catch (Exception e) 
		 {
			e.printStackTrace();
			return false;
		 }
	}

	public UserEntity loginUser(String username) 
	{
	   return userRepo.getByuserEmail(username);
	}

	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}

}
