package com.danya.pon.Spring_application_Danya_Ponomarev.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "salon")
public class Salon extends BaseModels{
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    @OneToMany(mappedBy = "owner")
    private List<Reviews> reviews;

    public Salon() {
    }

    public Salon(String name, String description, String location, List<Car> cars, List<Reviews> reviews) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.cars = cars;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                ", reviews=" + reviews +
                '}';
    }
}
