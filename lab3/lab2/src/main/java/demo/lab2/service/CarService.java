package demo.lab2.service;

import demo.lab2.model.Car;
import demo.lab2.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    public boolean updateCar(Car car, int id) {
        return carRepository.updateCar(car, id);
    }

    public boolean deleteCar(int id) {
        return carRepository.deleteCar(id);
    }

    public int getDealershipPrice() {
        int price = 0;
        for (Car car : carRepository.getAllCars()) {
            price += car.getPrice();
        }
        return price;
    }

    public List<Car> getAffordableCars(int maxPrice) {
        List<Car> affordableCars = new ArrayList<>();
        for (Car car : carRepository.getAllCars()) {
            if (car.getPrice() < maxPrice)
                affordableCars.add(car);
        }
        return affordableCars;
    }

    public List<Car> getCarsByType(String bodyType) {
        List<Car> carsByType = new ArrayList<>();
        for (Car car : carRepository.getAllCars()) {
            if (car.getBodyType().equals(bodyType))
                carsByType.add(car);
        }
        return carsByType;
    }

    public List<Car> getTakenCars() {
        return carRepository.getTakenCars();
    }

    public boolean takeCarForDrive(int id) {
        return carRepository.takeCarForDrive(id);
    }

    public boolean returnCar(int id) {
        return carRepository.returnCar(id);
    }
}
