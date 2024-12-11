package com.danya.pon.Spring_application_Danya_Ponomarev.services.impl;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.repositories.ReviewsRepository;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.ReviewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Override
    public List<Reviews> getAll() {
        return reviewsRepository.findAll();
    }

    @Override
    public Reviews getById(int reviewId) {
        return reviewsRepository.findById(reviewId).orElse(null);
    }

    @Override
    public String create(Reviews reviews) {
        String result = "Объект не был создан";

        if(reviews != null){
            reviewsRepository.save(reviews);
            result = "Был создан новый объект";
        }

        return result;
    }

    @Override
    public String update(int reviewsId, Reviews reviewsUpdate) {
        String result = "Объект не был обновлен";
        if(reviewsUpdate != null && getById(reviewsId) != null){
            Reviews reviews = getById(reviewsId);

            reviews.setTitle(reviewsUpdate.getTitle());
            reviews.setDescription(reviews.getDescription());
            reviews.setEstimation(reviews.getEstimation());
            reviews.setOwner(reviewsUpdate.getOwner());

            create(reviews);

            result = "Объект был обновлен";
        }

        return result;
    }

    @Override
    public String delete(int reviewsId) {
        String result = "Объект не был удален";

        if(getById(reviewsId) != null){
            result = "Объект был удален";
            reviewsRepository.deleteById(reviewsId);
        }
        return result;
    }
}
