package com.project.sehirRehberi.service;

import com.project.sehirRehberi.entity.Category;
import com.project.sehirRehberi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listele() {
        return categoryRepository.findAll();
    }

    public Category idIleGetir(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category ekle(Category category) {
        return categoryRepository.save(category);
    }

    public Category guncelle(Long id, Category yeniCategory) {
        Category bulunanCategory = categoryRepository.findById(id).orElse(null);

        if (bulunanCategory != null) {
            bulunanCategory.setCategoryname(yeniCategory.getCategoryname());
            return categoryRepository.save(bulunanCategory);
        }

        return null;
    }

    public String sil(Long id) {
        Category bulunanCategory = categoryRepository.findById(id).orElse(null);

        if (bulunanCategory != null) {
            categoryRepository.delete(bulunanCategory);
            return "Silme başarılı";
        }

        return "Kayıt bulunamadı";
    }

    public List<Category> tumKategorileriGetir() {
        return categoryRepository.tumKategorileriGetir();
    }

    public Category idIleKategoriGetir(Long id) {
        return categoryRepository.idIleKategoriGetir(id);
    }

    public List<Category> kategoriAdaGoreGetir(String name) {
        return categoryRepository.kategoriAdaGoreGetir(name);
    }
}