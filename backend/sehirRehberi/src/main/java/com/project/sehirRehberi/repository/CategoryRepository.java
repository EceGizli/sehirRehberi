package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    List<Category> tumKategorileriGetir();

    @Query(value = "SELECT * FROM categories WHERE categoryid = :id", nativeQuery = true)
    Category idIleKategoriGetir(Long id);

    @Query(value = "SELECT * FROM categories WHERE categoryname LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Category> kategoriAdaGoreGetir(String name);
}