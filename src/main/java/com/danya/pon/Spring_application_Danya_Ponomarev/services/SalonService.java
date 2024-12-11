package com.danya.pon.Spring_application_Danya_Ponomarev.services;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> getAll();
    Salon getById(int salonId);
    String create(Salon salon);
    String update(Salon updateSalon, int salonId);
    String delete(int salonId);
}
