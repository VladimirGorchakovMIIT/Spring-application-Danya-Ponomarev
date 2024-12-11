package com.danya.pon.Spring_application_Danya_Ponomarev.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModels {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public BaseModels() {
    }

    public BaseModels(int id) {
        this.id = id;
    }
}
