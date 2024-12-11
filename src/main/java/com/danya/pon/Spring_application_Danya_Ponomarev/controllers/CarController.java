package com.danya.pon.Spring_application_Danya_Ponomarev.controllers;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Car;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.repositories.CarRepository;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceImpl carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int carId){
        return new ResponseEntity<>(carService.getById(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Car car){
        return new ResponseEntity<>(carService.create(car), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int carId, @RequestBody Car updateCar){
        return new ResponseEntity<>(carService.update(carId, updateCar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int carId){
        return new ResponseEntity<>(carService.delete(carId), HttpStatus.OK);
    }
}
