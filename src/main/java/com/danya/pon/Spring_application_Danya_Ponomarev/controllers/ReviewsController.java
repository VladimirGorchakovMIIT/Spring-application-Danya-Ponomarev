package com.danya.pon.Spring_application_Danya_Ponomarev.controllers;

import com.danya.pon.Spring_application_Danya_Ponomarev.models.Reviews;
import com.danya.pon.Spring_application_Danya_Ponomarev.models.Salon;
import com.danya.pon.Spring_application_Danya_Ponomarev.services.impl.ReviewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewsController {
    private final ReviewsServiceImpl reviewsService;

    @GetMapping
    public ResponseEntity<List<Reviews>> getAll(){
        return new ResponseEntity<>(reviewsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getById(@PathVariable("id") int reviewId){
        return new ResponseEntity<>(reviewsService.getById(reviewId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Reviews reviews){
        return new ResponseEntity<>(reviewsService.create(reviews), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int reviewId, @RequestBody Reviews updateReviews){
        return new ResponseEntity<>(reviewsService.update(reviewId, updateReviews), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int reviewId){
        return new ResponseEntity<>(reviewsService.delete(reviewId), HttpStatus.OK);
    }
}
