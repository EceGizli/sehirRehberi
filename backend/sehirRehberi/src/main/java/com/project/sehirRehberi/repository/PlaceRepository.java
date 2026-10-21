package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(value = "SELECT * FROM places WHERE cityid = :cityid", nativeQuery = true)
    List<Place> sehreGoreMekanGetir(Long cityid);

    @Query(value = "SELECT * FROM places WHERE categoryid = :categoryid", nativeQuery = true)
    List<Place> kategoriyeGoreMekanGetir(Long categoryid);
}