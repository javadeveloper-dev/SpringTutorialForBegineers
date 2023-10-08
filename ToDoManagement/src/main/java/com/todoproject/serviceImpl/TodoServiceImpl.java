package com.todoproject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoproject.dto.TodoDTO;
import com.todoproject.entity.Todo;
import com.todoproject.exception.ResourceNotFoundException;
import com.todoproject.repository.TodoRepository;
import com.todoproject.service.TodoService;
@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired(required=true)
	private TodoRepository todoRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public TodoDTO addTodo(TodoDTO todoDTO) {
		System.out.println("Todo DTO"+todoDTO);
		//Convert TodoDTO into Todo JPA Entity
//		Todo savedTodo=new Todo();
//		savedTodo.setTitle(todoDTO.getTitle());
//		savedTodo.setDecription(todoDTO.getDescription());
//		savedTodo.setCompleted(todoDTO.isCompleted());
		
		//Using ModelMapper class converting TodoDTO into Todo Entity
		Todo savedTodo=modelMapper.map(todoDTO, Todo.class);

		//Saving the Todo Entity
		 Todo save = todoRepository.save(savedTodo);
		 
		 //Converting the Todo JPA Entity into Todo DTO
		 System.out.println("Saved Todo Entity "+save);
//		 TodoDTO savedDTO=new TodoDTO();
//		 savedDTO.setId(save.getId());
//		 savedDTO.setTitle(save.getTitle());
//		 savedDTO.setDescription(save.getDecription());
//		 savedDTO.setCompleted(save.isCompleted());
		 
		 //By using ModelMapper class
		 
		 //Converting the Todo JPA Entity into Todo DTO
		 
		 TodoDTO savedDTO=modelMapper.map(savedTodo, TodoDTO.class);
		 
		return savedDTO;
	}

	@Override
	public TodoDTO getTodo(Long id) {
		Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo not found with id "+id));
		return modelMapper.map(todo,TodoDTO.class);
	}

	public List<TodoDTO> getAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		return todos.stream().map((todo)->modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {
		Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with id"+id));
		todo.setTitle(todoDTO.getTitle());
		todo.setDescription(todoDTO.getDescription());
		todo.setCompleted(todoDTO.isCompleted());
		
		//If the id is present then it update or it insert 
		todoRepository.save(todo);
		return modelMapper.map(todo, TodoDTO.class);	
	}

	@Override
	public void deleteTodo(Long id) {
	Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found With id"+id));	
	todoRepository.delete(todo);
	}

	@Override
	public TodoDTO completeTodo(Long id) {
		Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with given Id"+id));
		todo.setCompleted(Boolean.TRUE);
		Todo updatedTodo=todoRepository.save(todo);
		return modelMapper.map(updatedTodo, TodoDTO.class);
	}

	@Override
	public TodoDTO inCompleteTodo(Long id) {
		Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with id "+id));
		todo.setCompleted(Boolean.FALSE);
		Todo updatedTodo = todoRepository.save(todo);
		return modelMapper.map(updatedTodo, TodoDTO.class);
	}

}
