package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.Comment;
import com.project.sehirRehberi.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/listele")
    public List<Comment> listele() {
        return commentService.listele();
    }

    @GetMapping("/listele/{id}")
    public Comment idIleGetir(@PathVariable Long id) {
        return commentService.idIleGetir(id);
    }

    @PostMapping("/ekle")
    public Comment ekle(@RequestBody Comment comment) {
        return commentService.ekle(comment);
    }

    @PutMapping("/guncelle/{id}")
    public Comment guncelle(@PathVariable Long id, @RequestBody Comment yeniComment) {
        return commentService.guncelle(id, yeniComment);
    }

    @DeleteMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        return commentService.sil(id);
    }

    @GetMapping("/sorgu/place/{placeId}")
    public List<Comment> placeYorumlariniGetir(@PathVariable Long placeId) {
        return commentService.placeYorumlariniGetir(placeId);
    }

    @GetMapping("/sorgu/user/{userId}")
    public List<Comment> kullaniciYorumlariniGetir(@PathVariable Long userId) {
        return commentService.kullaniciYorumlariniGetir(userId);
    }

    @GetMapping("/sorgu/kelime/{kelime}")
    public List<Comment> kelimeyeGoreYorumGetir(@PathVariable String kelime) {
        return commentService.kelimeyeGoreYorumGetir(kelime);
    }
}