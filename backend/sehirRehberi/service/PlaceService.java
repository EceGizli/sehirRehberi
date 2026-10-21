package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.Place;
import com.project.sehirRehberi.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository repository;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public List<Place> getAll() {
        return repository.findAll();
    }

    public Place getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Place create(Place place) {
        return repository.save(place);
    }

    public Place update(Long id, Place details) {
        Place place = repository.findById(id).orElse(null);

        if (place != null) {
            place.setCityid(details.getCityid());
            place.setCategoryid(details.getCategoryid());
            place.setPlaceName(details.getPlaceName());
            place.setAddress(details.getAddress());
            place.setDescription(details.getDescription());

            return repository.save(place);
        }

        return null;
    }

    public String delete(Long id) {
        Place place = repository.findById(id).orElse(null);

        if (place != null) {
            repository.delete(place);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<Place> sehreGoreMekanGetir(Long cityid) {
        return repository.sehreGoreMekanGetir(cityid);
    }

    public List<Place> kategoriyeGoreMekanGetir(Long categoryid) {
        return repository.kategoriyeGoreMekanGetir(categoryid);
    }
}