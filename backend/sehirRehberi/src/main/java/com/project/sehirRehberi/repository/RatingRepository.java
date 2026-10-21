package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query(value = "SELECT * FROM ratings WHERE score > :score", nativeQuery = true)
    List<Rating> puandanBuyukRatingleriGetir(Integer score);

    @Query(value = "SELECT * FROM ratings WHERE placeid = :placeId", nativeQuery = true)
    List<Rating> placeRatingleriniGetir(Long placeId);

    @Query(value = "SELECT * FROM ratings WHERE user_id = :userId", nativeQuery = true)
    List<Rating> kullaniciRatingleriniGetir(Long userId);
}