package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.City;
import com.project.sehirRehberi.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/listele")
    public List<City> listele() {
        return cityService.listele();
    }

    @GetMapping("/listele/{id}")
    public City idIleGetir(@PathVariable Long id) {
        return cityService.idIleGetir(id);
    }

    @PostMapping("/ekle")
    public City ekle(@RequestBody City city) {
        return cityService.ekle(city);
    }

    @PutMapping("/guncelle/{id}")
    public City guncelle(@PathVariable Long id, @RequestBody City yeniCity) {
        return cityService.guncelle(id, yeniCity);
    }

    @DeleteMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        return cityService.sil(id);
    }

    @GetMapping("/sorgu/ad/{name}")
    public List<City> sehirAdaGoreGetir(@PathVariable String name) {
        return cityService.sehirAdaGoreGetir(name);
    }

    @GetMapping("/sorgu/mekan")
    public List<City> mekanBulunanSehirleriGetir() {
        return cityService.mekanBulunanSehirleriGetir();
    }
}