package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.Rating;
import com.project.sehirRehberi.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> listele() {
        return ratingRepository.findAll();
    }

    public Rating idIleGetir(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public Rating ekle(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating guncelle(Long id, Rating yeniRating) {
        Rating bulunanRating = ratingRepository.findById(id).orElse(null);

        if (bulunanRating != null) {
            bulunanRating.setUserId(yeniRating.getUserId());
            bulunanRating.setPlaceId(yeniRating.getPlaceId());
            bulunanRating.setScore(yeniRating.getScore());
            return ratingRepository.save(bulunanRating);
        }

        return null;
    }

    public String sil(Long id) {
        Rating bulunanRating = ratingRepository.findById(id).orElse(null);

        if (bulunanRating != null) {
            ratingRepository.delete(bulunanRating);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<Rating> puandanBuyukRatingleriGetir(Integer score) {
        return ratingRepository.puandanBuyukRatingleriGetir(score);
    }

    public List<Rating> placeRatingleriniGetir(Long placeId) {
        return ratingRepository.placeRatingleriniGetir(placeId);
    }

    public List<Rating> kullaniciRatingleriniGetir(Long userId) {
        return ratingRepository.kullaniciRatingleriniGetir(userId);
    }
}