package com.danya.pon.Spring_application_Danya_Ponomarev.services;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getById(int carId);
    String create(Car reviews);
    String update(int carId, Car carUpdate);
    String delete(int carId);
}
