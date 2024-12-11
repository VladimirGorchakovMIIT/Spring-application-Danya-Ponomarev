package com.danya.pon.Spring_application_Danya_Ponomarev.services.impl;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.repositories.SalonRepository;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.SalonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {
    private final SalonRepository salonRepository;
    @Override
    public List<Salon> getAll() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getById(int salonId) {
        return salonRepository.findById(salonId).orElse(null);
    }

    @Override
    public String create(Salon salon) {
        String result = "Объект не был создан";

        if(salon != null){
            salonRepository.save(salon);
            result = "Был создан новый объект";
        }

        return result;
    }

    @Override
    public String update(Salon updateSalon, int salonId) {
        String result = "Объект не был обновлен";
        if(updateSalon != null && getById(salonId) != null){
            Salon salon = getById(salonId);

            salon.setName(updateSalon.getName());
            salon.setDescription(updateSalon.getDescription());
            salon.setLocation(updateSalon.getLocation());

            create(salon);

            result = "Объект был обновлен";
        }

        return result;
    }

    @Override
    public String delete(int salonId) {
        String result = "Объект не был удален";

        if(getById(salonId) != null){
            result = "Объект был удален";
            salonRepository.deleteById(salonId);
        }
        return result;
    }
}
