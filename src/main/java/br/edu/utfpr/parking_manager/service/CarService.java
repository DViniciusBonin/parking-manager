package br.edu.utfpr.parking_manager.service;

import br.edu.utfpr.parking_manager.model.dao.CarDAO;
import br.edu.utfpr.parking_manager.model.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService extends AbstractService<Long, Car>{

    public CarService() {
        dao = new CarDAO();
    }

    public List<Car> getNotParkedCars() {
        List<Car>  cars =  dao.findAll();
        List<Car> carsNotParked = new ArrayList();
        for (Car car: cars) {
            System.out.println(car.toString());
            if(car.getParked() == false) {
                carsNotParked.add(car);
            }
        }

        return carsNotParked;
    }
}
