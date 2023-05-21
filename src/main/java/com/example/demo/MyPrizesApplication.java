package com.example.demo;

import com.example.demo.repository.goals.GoalsDAO;
import com.example.demo.repository.tasks.TasksDAO;
import com.example.demo.entity.Goal;
import com.example.demo.entity.Role;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;
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
	public CommandLineRunner commandLineRunner(UserService userService) {
		return runner -> createMultipleUsers(userService);

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
	Goal tempGoals1 = new Goal( "Cake",25);
	Goal tempGoals2 = new Goal("Aquapark",60);
	Goal tempGoals3 = new Goal("Lazy day",100);
	Goal tempGoals4 = new Goal("Football",50);
	Goal tempGoals5 = new Goal("Surprise",150);
		goalsDAO.save(tempGoals1);
		goalsDAO.save(tempGoals2);
		goalsDAO.save(tempGoals3);
		goalsDAO.save(tempGoals4);
		goalsDAO.save(tempGoals5);
	}

	private void createMultipleTasks(TasksDAO tasksDAO) {
		Task tempTasks1 = new Task( "First",10);
		Task tempTasks2 = new Task("Second", 15);
		Task tempTasks3 = new Task("Easy", 20);
		Task tempTasks4 = new Task("Hard",60);
		Task tempTasks5 = new Task("Easy-peasy",5);
		tasksDAO.save(tempTasks1);
		tasksDAO.save(tempTasks2);
		tasksDAO.save(tempTasks3);
		tasksDAO.save(tempTasks4);
		tasksDAO.save(tempTasks5);
	}


	private void createMultipleUsers(UserService userService) {
		User tempUser1 = new User("paul@gmail.com", "123qwe", "Jon", "Doe", true, Role.ADMIN);
		User tempUser2 = new User("den@gmail.com", "456qwe", "Den", "Dick", true, Role.USER);
		User tempUser3 = new User("mary@gmail.com", "109fred", "Mary", "Subby", true, Role.USER);
		User tempUser4 = new User("olga@gmail.com", "485kdns", "Olga", "Mud", true, Role.USER);
		User tempUser5 = new User("nik@gmail.com", "877vhd", "Nik", "Finger", true, Role.USER);
		User tempUser6 = new User("luca@gmail.com", "974szdhfgh", "Luka", "Inet", true, Role.USER);
		userService.save(tempUser1);
		userService.save(tempUser2);
		userService.save(tempUser3);
		userService.save(tempUser4);
		userService.save(tempUser5);
		userService.save(tempUser6);
	}

}
