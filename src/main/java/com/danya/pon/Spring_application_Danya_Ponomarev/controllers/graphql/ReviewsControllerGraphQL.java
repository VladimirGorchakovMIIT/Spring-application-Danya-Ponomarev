package com.danya.pon.Spring_application_Danya_Ponomarev.controllers.graphql;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.ReviewsServiceImpl;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.SalonServiceImpl;
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
public class ReviewsControllerGraphQL {
    private final ReviewsServiceImpl reviewsService;
    private final SalonServiceImpl salonService;

    @QueryMapping
    public List<Reviews> getAllReviews(){
        return reviewsService.getAll();
    }

    @QueryMapping
    public Reviews getReviewsById(@Argument int reviewId){
        return reviewsService.getById(reviewId);
    }

    @MutationMapping
    public String createReviews(@Argument ReviewsInput inputReviews, @Argument int ownerId){
        Reviews reviews = new Reviews(inputReviews.title,
                inputReviews.description,
                Double.parseDouble(inputReviews.estimation.toString()),
                salonService.getById(ownerId));

        return reviewsService.create(reviews);
    }

    @MutationMapping
    public String updateReviews(@Argument int reviewsId, @Argument ReviewsInput reviewsInput, @Argument int ownerId){
        Reviews reviews = new Reviews(reviewsInput.title,
                reviewsInput.description,
                Double.parseDouble(reviewsInput.estimation.toString()),
                salonService.getById(ownerId));

        return reviewsService.update(reviewsId, reviews);
    }

    @MutationMapping
    public String deleteReviews(@Argument int reviewsId){
        return reviewsService.delete(reviewsId);
    }

    private record ReviewsInput(String title, String description, Float estimation){}
}
