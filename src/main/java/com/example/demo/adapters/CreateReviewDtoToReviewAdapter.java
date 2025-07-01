package com.example.demo.adapters;

import com.example.demo.dtos.CreateReviewDto;
import com.example.demo.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
