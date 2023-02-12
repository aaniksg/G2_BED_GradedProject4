package com.greatlearning.ems.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.entity.Role;
import com.greatlearning.ems.entity.User;
import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.repository.UserRepository;

@Configuration
public class ApplicationData {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void insertAppData(ApplicationReadyEvent event) {

		User admin = new User("admin", passwordEncoder.encode("admin"));
		User user = new User("user", passwordEncoder.encode("user"));

		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");

		admin.addRole(adminRole);
		user.addRole(userRole);

		userRepository.save(admin);
		userRepository.save(user);

		Employee emp1 = new Employee("Suresh", "Reddy", "suresh@email.com");
		Employee emp2 = new Employee("Murali", "Mohan", "murali@email.com");
		Employee emp3 = new Employee("Daniel", "Denson", "daniel@email.com");
		Employee emp4 = new Employee("Tanya", "Gupta", "tanya@email.com");
		Employee emp5 = new Employee("Suresh", "Mohan", "mohan@email.com");
		Employee emp6 = new Employee("Murali", "Gupta", "gupta@email.com");
		Employee emp7 = new Employee("Murali", "Reddy", "mreddy@email.com");

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
		employeeRepository.save(emp5);
		employeeRepository.save(emp6);
		employeeRepository.save(emp7);
	}
}
