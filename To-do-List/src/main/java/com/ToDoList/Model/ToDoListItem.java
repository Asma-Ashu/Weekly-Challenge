package com.ToDoList.Model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todo-app")
public class ToDoListItem 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="description not empty...")
	private String Description;
	boolean Done;
	private Instant createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isDone() {
		return Done;
	}
	public void setDone(boolean done) {
		this.Done = done;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	public ToDoListItem() {
		
	}
	public ToDoListItem(String description) 
	{
		this.Description = description;
		this.Done=false;
		this.createdDate=Instant.now();
	}
	@Override
	public String toString() {
		return "ToDoListItem [id=" + id + ", Description=" + Description + ", done=" + Done
				+ ", createdDate=" + createdDate + "]";
	} 
	
	
	
	
	
	

}
