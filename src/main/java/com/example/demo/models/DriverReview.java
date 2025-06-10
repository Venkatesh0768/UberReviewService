package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "driver_review_id")
public class DriverReview extends Review {
    private String driverReviewComment;
}
