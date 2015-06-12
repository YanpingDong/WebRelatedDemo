package com.dyp.JpaProject.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyp.JpaProject.persist.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {

}