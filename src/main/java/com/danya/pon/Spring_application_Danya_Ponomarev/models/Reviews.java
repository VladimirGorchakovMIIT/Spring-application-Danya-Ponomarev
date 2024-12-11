package com.danya.pon.Spring_application_Danya_Ponomarev.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Reviews extends BaseModels{
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "estimation")
    private Double estimation;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "salon_id", referencedColumnName = "id")
    private Salon owner;

    public Reviews() {
    }

    public Reviews(String title, String description, Double estimation, Salon owner) {
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", estimation=" + estimation +
                ", owner=" + owner +
                '}';
    }
}
