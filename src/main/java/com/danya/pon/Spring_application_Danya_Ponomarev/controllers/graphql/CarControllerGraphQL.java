package com.danya.pon.Spring_application_Danya_Ponomarev.controllers.graphql;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Car;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.CarServiceImpl;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.ReviewsServiceImpl;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.SalonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarControllerGraphQL {
    private final CarServiceImpl carService;
    private final SalonServiceImpl salonService;

    @QueryMapping
    public List<Car> getAllCar(){
        return carService.getAll();
    }

    @QueryMapping
    public Car getCarById(@Argument int carId){
        return carService.getById(carId);
    }

    @MutationMapping
    public String createCar(@Argument CarInput carInput, @Argument int ownerId){
        Car car = new Car(
                carInput.model,
                carInput.bodyType,
                carInput.engineType,
                carInput.horsepower,
                Double.parseDouble(carInput.fuelConsumption.toString()),
                salonService.getById(ownerId)
        );

        return carService.create(car);
    }

    @MutationMapping
    public String updateCar(@Argument int carId, @Argument CarInput carInput, @Argument int ownerId){
        Car car = new Car(
                carInput.model,
                carInput.bodyType,
                carInput.engineType,
                carInput.horsepower,
                Double.parseDouble(carInput.fuelConsumption.toString()),
                salonService.getById(ownerId)
        );

        return carService.update(carId, car);
    }

    @MutationMapping
    public String deleteCar(@Argument int carId){
        return carService.delete(carId);
    }

    private record CarInput(String model, String bodyType, String engineType, Integer horsepower, Float fuelConsumption){}
}
