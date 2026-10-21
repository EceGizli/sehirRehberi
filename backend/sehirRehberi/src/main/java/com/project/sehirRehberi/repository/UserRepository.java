package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<User> ismeGoreKullaniciGetir(String name);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User emailIleKullaniciGetir(String email);
}