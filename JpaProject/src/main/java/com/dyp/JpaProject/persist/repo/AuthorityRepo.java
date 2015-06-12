package com.dyp.JpaProject.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyp.JpaProject.persist.entity.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, Long> {

}
