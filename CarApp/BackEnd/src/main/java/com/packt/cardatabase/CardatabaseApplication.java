package com.packt.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database
			
			// Add owner objects and save these to db
			Owner owner1 = new Owner("John","Johnson");
			Owner owner2 = new Owner("Mary","Robinson");
			
			this.ownerRepository.save(owner1);
			this.ownerRepository.save(owner2);
			
			this.carRepository.save(new Car("Ford","Mustang","Red","ADF-1121",2017,59000, owner1));
			this.carRepository.save(new Car("Nissan","Leaf","White","SSJ-3002",2014,29000, owner1));
			this.carRepository.save(new Car("Toyota","Prius","Silver","KKO-0212",2018,39000,owner2));
			
			// username: user password: user
			userRepository.save(new User("user","$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi","USER"));
			// username: admin password: admin
			userRepository.save(new User("admin","$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG","ADMIN"));
			
		};
	}
}
