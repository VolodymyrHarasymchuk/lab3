package demo.lab2.repository;

import demo.lab2.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private final List<Car> carList = new ArrayList<>();
    private final List<Car> takenCars = new ArrayList<>();

    public List<Car> getAllCars() {
        return new ArrayList<>(carList);
    }

    public void addCar(Car car) {
        if(!carList.isEmpty()) {
            car.setId(carList.get(carList.size()-1).getId()+1);
        }
        carList.add(car);
    }

    public boolean updateCar(Car car, int id) {
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getId() == id) {
                carList.set(i, car);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCar(int id) {
        for (Car car : carList) {
            if(car.getId() == id) {
                carList.remove(car);
                return true;
            }
        }
        return false;
    }

    public List<Car> getTakenCars() {
        return new ArrayList<>(takenCars);
    }

    public boolean takeCarForDrive(int id) {
        for (Car car : carList) {
            if(car.getId() == id) {
                takenCars.add(car);
                carList.remove(car);
                return true;
            }
        }
        return false;
    }

    public boolean returnCar(int id) {
        for (Car car : takenCars) {
            if(car.getId() == id) {
                carList.add(car);
                takenCars.remove(car);
                return true;
            }
        }
        return false;
    }
}
