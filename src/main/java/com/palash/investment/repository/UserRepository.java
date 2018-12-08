package com.palash.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palash.investment.model.UserModel;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findByPhone(String phone); 
	
	UserModel findByEmail(String email);
	
	UserModel findByUsername(String username);
}
