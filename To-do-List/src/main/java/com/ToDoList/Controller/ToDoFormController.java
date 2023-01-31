package com.ToDoList.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.Model.ToDoListItem;
import com.ToDoList.Repository.ToDoRepo;

import jakarta.validation.Valid;

@RestController
public class ToDoFormController 
{
	@Autowired
	public ToDoRepo tdr;
	
	@GetMapping("/create-todo")
	public String showcreateForm() {
		return "add-todo-item";
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@Valid @RequestBody ToDoListItem todo,@PathVariable int id,Model model)
	{
		ToDoListItem td=tdr.findById(id).
				orElseThrow(()->new IllegalArgumentException("ToDoItem id :"+id+"not found!"));
		model.addAttribute("todo",td);
		return "update-todo-item";
	}
	

	@DeleteMapping("/delete/{id}")
	public String deleteTodoItem(@PathVariable int id)
	{
		ToDoListItem td=tdr.findById(id).
				orElseThrow(()->new IllegalArgumentException("ToDoItem id :"+id+"not found!"));
		tdr.delete(td);
		return "redirect:/";
	}

}
