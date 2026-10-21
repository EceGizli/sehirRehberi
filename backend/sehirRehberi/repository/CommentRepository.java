package com.project.sehirRehberi.repository;

import com.project.sehirRehberi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comments WHERE placeid = :placeId", nativeQuery = true)
    List<Comment> placeYorumlariniGetir(Long placeId);

    @Query(value = "SELECT * FROM comments WHERE userid = :userId", nativeQuery = true)
    List<Comment> kullaniciYorumlariniGetir(Long userId);

    @Query(value = "SELECT * FROM comments WHERE text LIKE CONCAT('%', :kelime, '%')", nativeQuery = true)
    List<Comment> kelimeyeGoreYorumGetir(String kelime);
}