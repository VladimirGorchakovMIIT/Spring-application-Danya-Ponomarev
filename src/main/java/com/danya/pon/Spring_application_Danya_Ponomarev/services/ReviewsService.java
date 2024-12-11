package com.danya.pon.Spring_application_Danya_Ponomarev.services;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAll();
    Reviews getById(int reviewId);
    String create(Reviews reviews);
    String update(int reviewsId, Reviews reviewsUpdate);
    String delete(int reviewsId);
}
