package com.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoproject.entity.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}
