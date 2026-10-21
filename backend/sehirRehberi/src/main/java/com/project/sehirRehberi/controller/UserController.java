package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.User;
import com.project.sehirRehberi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listele")
    public List<User> listele() {
        return userService.listele();
    }

    @GetMapping("/listele/{id}")
    public User idIleGetir(@PathVariable Long id) {
        return userService.idIleGetir(id);
    }

    @PostMapping("/ekle")
    public User ekle(@RequestBody User user) {
        return userService.ekle(user);
    }

    @PutMapping("/guncelle/{id}")
    public User guncelle(@PathVariable Long id, @RequestBody User yeniUser) {
        return userService.guncelle(id, yeniUser);
    }

    @DeleteMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        return userService.sil(id);
    }

    @GetMapping("/sorgu/ad/{name}")
    public List<User> ismeGoreKullaniciGetir(@PathVariable String name) {
        return userService.ismeGoreKullaniciGetir(name);
    }

    @GetMapping("/sorgu/email/{email}")
    public User emailIleKullaniciGetir(@PathVariable String email) {
        return userService.emailIleKullaniciGetir(email);
    }
}