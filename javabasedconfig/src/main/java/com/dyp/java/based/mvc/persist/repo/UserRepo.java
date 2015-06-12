package com.dyp.java.based.mvc.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyp.java.based.mvc.persist.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}