package com.danya.pon.Spring_application_Danya_Ponomarev.repositories;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
}
