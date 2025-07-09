package com.example.demo;


import com.example.demo.adapters.CreateReviewDtoToReviewAdapterImpl;
import com.example.demo.controllers.ReviewController;
import com.example.demo.dtos.CreateReviewDto;
import org.example.uberprojectentityservice.models.Booking;
import org.example.uberprojectentityservice.models.Review;
import com.example.demo.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    public ReviewController reviewController;
    @Mock
    public ReviewService reviewService;
    @Mock
    public CreateReviewDtoToReviewAdapterImpl  createReviewDtoToReviewAdapter;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  testFindReviewById_Success(){
        long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);
        //mocking
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));

        //perform of the test
        ResponseEntity<?> response = reviewController.findReviewById(reviewId);

        //asseration
        assertEquals(HttpStatus.OK , response.getStatusCode());

        Optional<Review> returnedReview = (Optional<Review>)response.getBody();
        assertEquals(reviewId , returnedReview.get().getId());
    }


    @Test
    public void testPublishReview_Success(){
        CreateReviewDto requestDto = new CreateReviewDto();
        Booking booking = new Booking();
        booking.setId(1L);
        requestDto.setBookingId(booking.getId());

        Review incomingReview = Review.builder()
                .content("Test review Content")
                .rating(4.5)
                .booking(booking)
                .build();

        when(createReviewDtoToReviewAdapter.convertDto(requestDto)).thenReturn(incomingReview);

        Review savedReview = Review.builder()
                .content(incomingReview.getContent())
                .rating(incomingReview.getRating())
                .booking(incomingReview.getBooking())
                .build();

        when(reviewService.publishReview(incomingReview)).thenReturn(savedReview);

        ResponseEntity<?> response = reviewController.publishReview(requestDto);
        assertEquals(HttpStatus.CREATED , response.getStatusCode());
    }


}
