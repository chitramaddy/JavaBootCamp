package com.example.ChitraMadhanCarLotJpaRepository;

import com.example.ChitraMadhanCarLotJpaRepository.dao.CarRepository;
import com.example.ChitraMadhanCarLotJpaRepository.dto.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChitraMadhanCarLotJpaRepositoryApplicationTests {

		@Autowired
	CarRepository carRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest(){
		carRepo.deleteAll();

		Car car = new Car();

		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2016");
		car.setColor("Black");

		carRepo.save(car);

		List<Car> carList = carRepo.findAll();
		assertEquals(1, carList.size());

	}

	@Test
	public void getAllCars() {

		Car car = new Car();
		car.setMake("Honda");
		car.setModel("CB300");
		car.setYear("2019");
		car.setColor("red");

		carRepo.save(car);

		car = new Car();
		car.setMake("Suzuki");
		car.setModel("DR650");
		car.setYear("2012");
		car.setColor("gray");

		carRepo.save(car);

		List<Car> carList = carRepo.findAll();

		assertEquals(carList.size(), 2);
	}

	@Test
	public void updateCar() {

		Car car = new Car();
		car.setMake("Honda");
		car.setModel("Odyssey");
		car.setYear("2019");
		car.setColor("black");

		car = carRepo.save(car);

		car.setMake("UPDATED");
		car.setModel("NEW MODEL");
		car.setYear("1111");
		car.setColor("NEW COLOR");




		Optional<Car> car2 = carRepo.findById(car.getId());;

		assertEquals(car2, car);
	}



}
