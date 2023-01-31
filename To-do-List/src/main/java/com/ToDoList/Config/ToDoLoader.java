package com.ToDoList.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ToDoList.Model.ToDoListItem;
import com.ToDoList.Repository.ToDoRepo;
@Component
public class ToDoLoader implements CommandLineRunner
{
	private final Logger logger=LoggerFactory.getLogger(ToDoLoader.class);
	
	@Autowired
	public ToDoRepo tdr;

	@Override
	public void run(String... args) throws Exception {
		loadseeddata();
		
	}

	private void loadseeddata() {
		if(tdr.count()==0)
		{
			ToDoListItem td1=new ToDoListItem("prepare the presentation");
			ToDoListItem td2=new ToDoListItem("deliver to the clients");
			tdr.save(td1);
			tdr.save(td2);
		}
		logger.info("Number of to-do items : {}",tdr.count());
		
	}
	

}
