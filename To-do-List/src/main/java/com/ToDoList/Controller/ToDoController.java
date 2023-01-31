package com.ToDoList.Controller;

import java.time.Instant;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ToDoList.Model.ToDoListItem;
import com.ToDoList.Repository.ToDoRepo;

import jakarta.validation.Valid;

@RestController
public class ToDoController {
	private final Logger logger=LoggerFactory.getLogger(ToDoController.class);
	@Autowired
	public ToDoRepo tdr;
	@GetMapping("/")
	public ModelAndView index() {
		logger.debug("Request to Get Index page");
		ModelAndView mv= new ModelAndView("index.html");
		mv.addObject("todoItems",tdr.findAll());
		mv.addObject("today",Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
		return mv;
		
	}
	@PostMapping("/todo")
	public String createTodoList(@Valid @RequestBody ToDoListItem item,BindingResult result,Model model)
	{
		if(result.hasErrors()) {
			return "add-todo-items";
		}
		item.setCreatedDate(Instant.now());
		tdr.save(item);
		return "redirect:/" ;	
	}
	@PostMapping("/todo/{id}")
	public String updateToDoList(@Valid @RequestBody ToDoListItem item,@PathVariable int id,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			item.setId(id);
			return "Update-todo-items";
		}
		tdr.save(item);
		return "redirect:/";
		
	}
	@DeleteMapping("/todo/{id}")
	public String deleteToDoList(@PathVariable int id)
	{
		tdr.deleteById(id);
		return "ToDoItem Deleted Successfully!!";
	}
	

}
