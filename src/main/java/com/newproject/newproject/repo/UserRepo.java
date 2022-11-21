package com.newproject.newproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.newproject.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public UserEntity getByuserEmail(String username);
}
