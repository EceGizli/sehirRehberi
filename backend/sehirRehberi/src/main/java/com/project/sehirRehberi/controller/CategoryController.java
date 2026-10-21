package com.project.sehirRehberi.controller;

import com.project.sehirRehberi.entity.Category;
import com.project.sehirRehberi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listele")
    public List<Category> listele() {
        return categoryService.listele();
    }

    @GetMapping("/listele/{id}")
    public Category idIleGetir(@PathVariable Long id) {
        return categoryService.idIleGetir(id);
    }

    @PostMapping("/ekle")
    public Category ekle(@RequestBody Category category) {
        return categoryService.ekle(category);
    }

    @PutMapping("/guncelle/{id}")
    public Category guncelle(@PathVariable Long id, @RequestBody Category yeniCategory) {
        return categoryService.guncelle(id, yeniCategory);
    }

    @DeleteMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        return categoryService.sil(id);
    }

    @GetMapping("/sorgu/tum")
    public List<Category> tumKategorileriGetir() {
        return categoryService.tumKategorileriGetir();
    }

    @GetMapping("/sorgu/id/{id}")
    public Category idIleKategoriGetir(@PathVariable Long id) {
        return categoryService.idIleKategoriGetir(id);
    }

    @GetMapping("/sorgu/ad/{name}")
    public List<Category> kategoriAdaGoreGetir(@PathVariable String name) {
        return categoryService.kategoriAdaGoreGetir(name);
    }
}