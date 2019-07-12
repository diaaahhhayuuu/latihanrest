package com.eksad.latihanrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eksad.latihanrest.model.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	public Users findByUsername(String username);
}
