package com.danya.pon.Spring_application_Danya_Ponomarev.services.impl;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Car;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import com.danya.pon.Spring_application_Danya_Ponomarev.repositories.CarRepository;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(int carId) {
        return carRepository.findById(carId).orElse(null);
    }

    @Override
    public String create(Car reviews) {
        String result = "Объект не был создан";

        if(reviews != null){
            carRepository.save(reviews);
            result = "Был создан новый объект";
        }

        return result;
    }

    @Override
    public String update(int carId, Car carUpdate) {
        String result = "Объект не был обновлен";
        if(carUpdate != null && getById(carId) != null){
            Car car = getById(carId);

            car.setModel(carUpdate.getModel());
            car.setBodyType(carUpdate.getBodyType());
            car.setEngineType(carUpdate.getEngineType());
            car.setHorsepower(carUpdate.getHorsepower());
            car.setFuelConsumption(carUpdate.getFuelConsumption());

            car.setOwner(carUpdate.getOwner());

            create(car);

            result = "Объект был обновлен";
        }

        return result;
    }

    @Override
    public String delete(int carId) {
        String result = "Объект не был удален";

        if(getById(carId) != null){
            result = "Объект был удален";
            carRepository.deleteById(carId);
        }
        return result;
    }
}
