package com.packt.cardatabase.domain;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car,Long> {

	// Fetch cars by brand
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(String brand);
	
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
	// Fetch cars by color
	List<Car> findByColor(String color);
	
	//Fetch cars by year
	List<Car> findByYear(int year);
}
