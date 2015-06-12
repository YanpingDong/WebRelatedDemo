package com.dyp.java.based.mvc.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyp.java.based.mvc.persist.entity.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, Long> {

}
