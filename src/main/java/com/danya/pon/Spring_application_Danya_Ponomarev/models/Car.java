package com.danya.pon.Spring_application_Danya_Ponomarev.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends BaseModels{
    @Column(name = "model")
    private String model; // Модель

    @Column(name = "bodyType")
    private String bodyType; // Тип кузова

    @Column(name = "engineType")
    private String engineType; // Тип двигателя

    @Column(name = "horsepower")
    private int horsepower; // Мощность двигателя

    @Column(name = "fuelConsumption")
    private Double fuelConsumption; // Расход топлива

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "salon_id", referencedColumnName = "id")
    private Salon owner;

    public Car() {
    }

    public Car(String model, String bodyType, String engineType, int horsepower, Double fuelConsumption, Salon owner) {
        this.model = model;
        this.bodyType = bodyType;
        this.engineType = engineType;
        this.horsepower = horsepower;
        this.fuelConsumption = fuelConsumption;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", horsepower=" + horsepower +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
