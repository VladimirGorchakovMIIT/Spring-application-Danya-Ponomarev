package com.danya.pon.Spring_application_Danya_Ponomarev.repositories;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {
}
