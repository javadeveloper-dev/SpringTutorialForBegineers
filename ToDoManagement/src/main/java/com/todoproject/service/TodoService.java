package com.todoproject.service;

import java.util.List;

import com.todoproject.dto.TodoDTO;

public interface TodoService {
	TodoDTO addTodo(TodoDTO todo);
	
	TodoDTO getTodo(Long id);
	
	List<TodoDTO> getAllTodos();
	
	TodoDTO updateTodo(TodoDTO todoDTO,Long id);
	
	void deleteTodo(Long id);
	
	TodoDTO completeTodo(Long id);
	
	TodoDTO inCompleteTodo(Long id);
}
