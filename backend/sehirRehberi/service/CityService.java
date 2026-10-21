package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.City;
import com.project.sehirRehberi.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> listele() {
        return cityRepository.findAll();
    }

    public City idIleGetir(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City ekle(City city) {
        return cityRepository.save(city);
    }

    public City guncelle(Long id, City yeniCity) {
        City bulunanCity = cityRepository.findById(id).orElse(null);

        if (bulunanCity != null) {
            bulunanCity.setCityname(yeniCity.getCityname());
            return cityRepository.save(bulunanCity);
        }

        return null;
    }

    public String sil(Long id) {
        City bulunanCity = cityRepository.findById(id).orElse(null);

        if (bulunanCity != null) {
            cityRepository.delete(bulunanCity);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<City> sehirAdaGoreGetir(String name) {
        return cityRepository.sehirAdaGoreGetir(name);
    }

    public List<City> mekanBulunanSehirleriGetir() {
        return cityRepository.mekanBulunanSehirleriGetir();
    }
}