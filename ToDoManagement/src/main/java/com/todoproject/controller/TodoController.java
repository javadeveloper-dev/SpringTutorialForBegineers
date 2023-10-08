package com.todoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoproject.dto.TodoDTO;
import com.todoproject.service.TodoService;

@RestController
@RequestMapping("/todos/")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	//Build Add Todo Rest API
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("addTodo")
	public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todo){
		TodoDTO savedTodo=todoService.addTodo(todo);
		return new ResponseEntity<>(savedTodo,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("{id}")
	public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long getId){
		TodoDTO getTodoDTO=todoService.getTodo(getId);
		return new ResponseEntity<>(getTodoDTO,HttpStatus.OK);
	}
	
	
	//Build All get REST API
	@GetMapping("getAllTodos")
	public ResponseEntity<List<TodoDTO>> getAllTodos(){
		List<TodoDTO> todos=todoService.getAllTodos();
//		return new ResponseEntity<>(todos,HttpStatus.OK);
		return ResponseEntity.ok(todos);
	}
	
	
	//Build Update  Rest API
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO,@PathVariable Long id){
		TodoDTO updatedTodo=todoService.updateTodo(todoDTO, id);
		return ResponseEntity.ok(updatedTodo);
	}
	
	//Build Delete REST API
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id){
		todoService.deleteTodo(id);
		return ResponseEntity.ok("Todo Deleted Successfully..");
		
	}
	
	//Build complete REST API
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@PatchMapping("{id}")
	public ResponseEntity<TodoDTO> completeTodo(@PathVariable Long id){
		TodoDTO updateTodo=todoService.completeTodo(id);
		return ResponseEntity.ok(updateTodo);
	}
	
	//Build Incomplete REST API
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@PatchMapping("incompleteTodo/{id}")
	public ResponseEntity<TodoDTO> inCompleteTodo(@PathVariable Long id){
		TodoDTO updatedTodo=todoService.inCompleteTodo(id);
		return ResponseEntity.ok(updatedTodo);
	}
	
}
