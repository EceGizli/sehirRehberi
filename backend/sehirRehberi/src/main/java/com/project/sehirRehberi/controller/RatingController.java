package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.Rating;
import com.project.sehirRehberi.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/listele")
    public List<Rating> listele() {
        return ratingService.listele();
    }

    @GetMapping("/listele/{id}")
    public Rating idIleGetir(@PathVariable Long id) {
        return ratingService.idIleGetir(id);
    }

    @PostMapping("/ekle")
    public Rating ekle(@RequestBody Rating rating) {
        return ratingService.ekle(rating);
    }

    @PutMapping("/guncelle/{id}")
    public Rating guncelle(@PathVariable Long id, @RequestBody Rating yeniRating) {
        return ratingService.guncelle(id, yeniRating);
    }

    @DeleteMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        return ratingService.sil(id);
    }

    @GetMapping("/sorgu/puan/{score}")
    public List<Rating> puandanBuyukRatingleriGetir(@PathVariable Integer score) {
        return ratingService.puandanBuyukRatingleriGetir(score);
    }

    @GetMapping("/sorgu/place/{placeId}")
    public List<Rating> placeRatingleriniGetir(@PathVariable Long placeId) {
        return ratingService.placeRatingleriniGetir(placeId);
    }

    @GetMapping("/sorgu/user/{userId}")
    public List<Rating> kullaniciRatingleriniGetir(@PathVariable Long userId) {
        return ratingService.kullaniciRatingleriniGetir(userId);
    }
}