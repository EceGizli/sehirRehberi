package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT * FROM cities WHERE cityname LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<City> sehirAdaGoreGetir(String name);

    @Query(value = "SELECT DISTINCT c.* FROM cities c JOIN places p ON c.cityid = p.cityid", nativeQuery = true)
    List<City> mekanBulunanSehirleriGetir();
}