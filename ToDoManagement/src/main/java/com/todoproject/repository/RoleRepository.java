package com.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoproject.entity.Role;

public interface RoleRepository  extends JpaRepository<Role,Long> {
	

}
