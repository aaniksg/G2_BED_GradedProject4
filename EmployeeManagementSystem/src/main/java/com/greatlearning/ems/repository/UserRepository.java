package com.greatlearning.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.ems.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByUsername(String username);

}
