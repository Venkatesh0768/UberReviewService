package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BookingReview")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;
}
