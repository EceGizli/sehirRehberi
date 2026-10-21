package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.Place;
import com.project.sehirRehberi.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getAll() {
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable Long id) {
        return placeService.getById(id);
    }

    @PostMapping
    public Place create(@RequestBody Place place) {
        return placeService.create(place);
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable Long id, @RequestBody Place details) {
        return placeService.update(id, details);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return placeService.delete(id);
    }

    @GetMapping("/sorgu/sehir/{cityid}")
    public List<Place> sehreGoreMekanGetir(@PathVariable Long cityid) {
        return placeService.sehreGoreMekanGetir(cityid);
    }

    @GetMapping("/sorgu/kategori/{categoryid}")
    public List<Place> kategoriyeGoreMekanGetir(@PathVariable Long categoryid) {
        return placeService.kategoriyeGoreMekanGetir(categoryid);
    }
}