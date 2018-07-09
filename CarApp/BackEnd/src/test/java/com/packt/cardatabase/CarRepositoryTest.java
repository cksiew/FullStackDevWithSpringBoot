package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;



@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	
	
	@Test
	public void saveCar() {
		
		Owner owner1 = new Owner("John","Johnson");
		entityManager.persistAndFlush(owner1);
		Car car = new Car("Telsa", "Model X", "White", "ABC-1234",2017,86000,owner1);
		entityManager.persistAndFlush(car);
		
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCars() {
		Owner owner1 = new Owner("John","Johnson");
		entityManager.persistAndFlush(owner1);
		entityManager.persistAndFlush(new Car("Telsa", "Model X", "White", "ABC-1234",2017,86000,owner1));
		entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007",2015,24500,owner1));
		
		carRepository.deleteAll();
		assertThat(carRepository.findAll()).isEmpty();
	}
}
