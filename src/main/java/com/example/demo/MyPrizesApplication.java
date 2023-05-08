package com.example.demo;

import com.example.demo.repository.goals.GoalsDAO;
import com.example.demo.repository.tasks.TasksDAO;
import com.example.demo.repository.user.UserDAO;
import com.example.demo.entity.Goals;
import com.example.demo.entity.Role;
import com.example.demo.entity.Tasks;
import com.example.demo.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPrizesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPrizesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO) {
		return runner -> createMultipleUsers(userDAO);

	}

	@Bean
	public CommandLineRunner commandLineRunner2(TasksDAO tasksDAO){
		return runner -> createMultipleTasks(tasksDAO);
	}

	@Bean
	public CommandLineRunner commandLineRunner3(GoalsDAO goalsDAO){
		return runner -> createMultipleGoals(goalsDAO);
	}

	private void createMultipleGoals(GoalsDAO goalsDAO) {
	Goals tempGoals1 = new Goals( "Cake",25);
	Goals tempGoals2 = new Goals("Aquapark",60);
	Goals tempGoals3 = new Goals("Lazy day",100);
	Goals tempGoals4 = new Goals("Football",50);
	Goals tempGoals5 = new Goals("Surprise",150);
		goalsDAO.save(tempGoals1);
		goalsDAO.save(tempGoals2);
		goalsDAO.save(tempGoals3);
		goalsDAO.save(tempGoals4);
		goalsDAO.save(tempGoals5);
	}

	private void createMultipleTasks(TasksDAO tasksDAO) {
		Tasks tempTasks1 = new Tasks( "First",10);
		Tasks tempTasks2 = new Tasks("Second", 15);
		Tasks tempTasks3 = new Tasks("Easy", 20);
		Tasks tempTasks4 = new Tasks("Hard",60);
		Tasks tempTasks5 = new Tasks("Easy-peasy",5);
		tasksDAO.save(tempTasks1);
		tasksDAO.save(tempTasks2);
		tasksDAO.save(tempTasks3);
		tasksDAO.save(tempTasks4);
		tasksDAO.save(tempTasks5);
	}


	private void createMultipleUsers(UserDAO userDAO) {
		Users tempUser1 = new Users("paul@gmail.com", "123qwe", "Jon", "Doe", true, Role.ADMIN);
		Users tempUser2 = new Users("den@gmail.com", "456qwe", "Den", "Dick", true, Role.USER);
		Users tempUser3 = new Users("mary@gmail.com", "789qwe", "Mary", "Subby", true, Role.USER);
		userDAO.save(tempUser1);
		userDAO.save(tempUser2);
		userDAO.save(tempUser3);
	}

}
