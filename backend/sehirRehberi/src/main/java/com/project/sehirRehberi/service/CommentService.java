package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.Comment;
import com.project.sehirRehberi.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> listele() {
        return commentRepository.findAll();
    }

    public Comment idIleGetir(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment ekle(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment guncelle(Long id, Comment yeniComment) {
        Comment bulunanComment = commentRepository.findById(id).orElse(null);

        if (bulunanComment != null) {
            bulunanComment.setUserId(yeniComment.getUserId());
            bulunanComment.setPlaceId(yeniComment.getPlaceId());
            bulunanComment.setText(yeniComment.getText());
            return commentRepository.save(bulunanComment);
        }

        return null;
    }

    public String sil(Long id) {
        Comment bulunanComment = commentRepository.findById(id).orElse(null);

        if (bulunanComment != null) {
            commentRepository.delete(bulunanComment);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<Comment> placeYorumlariniGetir(Long placeId) {
        return commentRepository.placeYorumlariniGetir(placeId);
    }

    public List<Comment> kullaniciYorumlariniGetir(Long userId) {
        return commentRepository.kullaniciYorumlariniGetir(userId);
    }

    public List<Comment> kelimeyeGoreYorumGetir(String kelime) {
        return commentRepository.kelimeyeGoreYorumGetir(kelime);
    }
}