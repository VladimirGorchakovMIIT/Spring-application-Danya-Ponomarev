package com.danya.pon.Spring_application_Danya_Ponomarev.controllers;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.SalonService;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.SalonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/salon")
@RequiredArgsConstructor
public class SalonController {
    private final SalonServiceImpl salonService;

    @GetMapping
    public ResponseEntity<List<Salon>> getAll(){
        return new ResponseEntity<>(salonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getById(@PathVariable("id") int salonId){
        return new ResponseEntity<>(salonService.getById(salonId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Salon salon){
        return new ResponseEntity<>(salonService.create(salon), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int salonId, @RequestBody Salon updateSalon){
        return new ResponseEntity<>(salonService.update(updateSalon, salonId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int salonId){
        return new ResponseEntity<>(salonService.delete(salonId), HttpStatus.OK);
    }
}
