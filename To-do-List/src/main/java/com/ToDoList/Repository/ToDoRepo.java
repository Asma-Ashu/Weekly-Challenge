package com.ToDoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDoList.Model.ToDoListItem;
@Repository
public interface ToDoRepo extends JpaRepository<ToDoListItem,Integer> {

}
