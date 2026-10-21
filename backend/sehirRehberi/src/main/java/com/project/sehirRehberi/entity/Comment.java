package com.project.sehirRehberi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long commentid;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "placeid")
    private Long placeId;

    @Column(name = "text")
    private String text;
}