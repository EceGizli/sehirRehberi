package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.User;
import com.project.sehirRehberi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listele() {
        return userRepository.findAll();
    }

    public User idIleGetir(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User ekle(User user) {
        return userRepository.save(user);
    }

    public User guncelle(Long id, User yeniUser) {
        User bulunanUser = userRepository.findById(id).orElse(null);

        if (bulunanUser != null) {
            bulunanUser.setName(yeniUser.getName());
            bulunanUser.setLastname(yeniUser.getLastname());
            bulunanUser.setEmail(yeniUser.getEmail());

            return userRepository.save(bulunanUser);
        }

        return null;
    }

    public String sil(Long id) {
        User bulunanUser = userRepository.findById(id).orElse(null);

        if (bulunanUser != null) {
            userRepository.delete(bulunanUser);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<User> ismeGoreKullaniciGetir(String name) {
        return userRepository.ismeGoreKullaniciGetir(name);
    }

    public User emailIleKullaniciGetir(String email) {
        return userRepository.emailIleKullaniciGetir(email);
    }
}