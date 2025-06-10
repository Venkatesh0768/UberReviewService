package com.example.demo.services;

import com.example.demo.models.Review;
import com.example.demo.repositories.ReviewRepository;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private  ReviewRepository reviewRepository;

    ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***********");
        Review r = Review.builder()
            .content("Virus is pronstar")
            .rating(5.0)
            .build();
        System.out.println(r);
        reviewRepository.save(r);

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(review.getContent());
        }
    }




}
