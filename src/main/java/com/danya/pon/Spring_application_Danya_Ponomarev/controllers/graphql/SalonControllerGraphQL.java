package com.danya.pon.Spring_application_Danya_Ponomarev.controllers.graphql;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Car;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.SalonServiceImpl;
import graphql.Mutable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SalonControllerGraphQL {
    private final SalonServiceImpl salonService;

    @QueryMapping
    public List<Salon> getAllSalon(){
        return salonService.getAll();
    }

    @QueryMapping
    public Salon getSalonById(@Argument int salonId){
        return salonService.getById(salonId);
    }

    @MutationMapping
    public String createSalon(@Argument InputSalon inputSalon){
        Salon salon = new Salon(inputSalon.name, inputSalon.description,inputSalon.location, new ArrayList<>(), new ArrayList<>());
        return salonService.create(salon);
    }

    @MutationMapping
    public String updateSalon(@Argument int salonId, @Argument InputSalon inputSalon){
        Salon salon = new Salon(inputSalon.name, inputSalon.description,inputSalon.location, new ArrayList<>(), new ArrayList<>());
        return salonService.update(salon, salonId);
    }

    @MutationMapping
    public String deleteSalon(@Argument int salonId){
        return salonService.delete(salonId);
    }

    private record InputSalon(String name, String description, String location){}
}
