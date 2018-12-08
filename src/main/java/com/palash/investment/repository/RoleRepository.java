package com.palash.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palash.investment.model.RoleModel;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleModel, Integer>{

	RoleModel findById(int id);
}
