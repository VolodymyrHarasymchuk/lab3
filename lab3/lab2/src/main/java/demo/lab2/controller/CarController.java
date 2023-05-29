package demo.lab2.controller;

import demo.lab2.model.Car;
import demo.lab2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCar(@RequestBody Car car, int id) throws Exception {
        if (!carService.updateCar(car, id)) {
            throw new Exception();
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(int id) throws Exception {
        if (!carService.deleteCar(id)) {
            throw new Exception();
        }
    }

    @GetMapping("/dealership")
    public int getDealershipPrice() {
        return carService.getDealershipPrice();
    }

    @GetMapping("/affordable")
    public List<Car> getAffordableCars(@RequestParam int maxPrice) {
        return carService.getAffordableCars(maxPrice);
    }

    @GetMapping("/body-type")
    public List<Car> getCarsByType(@RequestParam String bodyType) {
        return carService.getCarsByType(bodyType);
    }

    @GetMapping("/taken")
    public List<Car> getTakenCars() {
        return carService.getTakenCars();
    }

    @PutMapping("/take")
    public void takeCarForDrive(@RequestParam int id) throws Exception {
        if (!carService.takeCarForDrive(id)) {
            throw new Exception();
        }
    }

    @PutMapping("/return")
    public void returnCar(@RequestParam int id) throws Exception {
        if (!carService.returnCar(id)) {
            throw new Exception();
        }
    }
}
