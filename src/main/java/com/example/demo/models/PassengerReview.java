package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "passenger_review_id")
public class PassengerReview extends Review{

    private String passengerReviewComment;
}
