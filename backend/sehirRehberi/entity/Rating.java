package com.project.sehirRehberi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ratings")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingid")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long ratingid;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "placeid")
    private Long placeId;

    @Column(name = "score")
    private Integer score;
}