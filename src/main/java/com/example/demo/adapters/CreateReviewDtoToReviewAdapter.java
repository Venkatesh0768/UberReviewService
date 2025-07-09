package com.example.demo.adapters;

import com.example.demo.dtos.CreateReviewDto;
import org.example.uberprojectentityservice.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
