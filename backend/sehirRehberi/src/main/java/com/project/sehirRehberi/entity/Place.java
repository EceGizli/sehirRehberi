package com.project.sehirRehberi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "places")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeid")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long placeId;

    @Column(name = "cityid")
    private Long cityid;

    @Column(name = "categoryid")
    private Long categoryid;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;
}