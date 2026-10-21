package com.project.sehirRehberi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cities")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityid")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long cityid;

    @Column(name = "cityname")
    private String cityname;
}