# Şehir Rehberi Projesi 

## Projenin Amacı
Bu projede, bir şehrin gezilecek yerlerini, kategorilerini ve bu yerlere yapılan yorumları yöneten bir sistem tasarlandı. Asıl amaç; PostgreSQL veritabanındaki verilere Spring Boot REST API üzerinden erişmek, yeni veri eklemek ve mevcut verileri güncelleyip silebilmektir.

## Kullanılan Teknolojiler

### Backend
* **Dil:** Java
* **Framework:** Spring Boot, Spring Data JPA
* **Veritabanı:** PostgreSQL (DBeaver ile tasarlandı)
* **Dokümantasyon:** Swagger UI / OpenAPI
* **Bağımlılıklar:** Lombok, Spring Web, Spring Boot DevTools

### Frontend
* **Kütüphane:** React (Vite)
* **Tasarım:** Özel CSS ve Kart Yapısı

## Temel Özellikler
* **Kullanıcı İşlemleri:** Kayıt olma ve giriş yapma.
* **Filtreleme & Arama:** Mekanların şehre ve kategoriye göre filtrelenmesi, arama çubuğu ile anlık arama yapılması.
* **Etkileşim:** Sisteme giriş yapan kullanıcıların mekanlara yorum yapabilmesi, 1-5 arası puan verebilmesi ve kendi yorum/puanlarını silebilmesi.
* **Katmanlı Mimari:** Entity, Repository, Service ve Controller (`@Query` ile özel SQL sorguları dahil).

## Kurulum ve Çalıştırma

### 1. Veritabanı Kurulumu
1. `database` klasöründeki SQL dump dosyasını DBeaver veya pgAdmin üzerinden içe aktararak tabloları (users, cities, categories, places, comments, ratings) oluşturun.

### 2. Backend (Spring Boot)
1. `backend/sehirRehberi` klasörünü IDE'nizde açın.
2. `application.properties` dosyasındaki veritabanı ayarlarınızı kontrol edin.
3. Projeyi çalıştırın. Swagger test arayüzüne `http://localhost:8080/swagger-ui/index.html` adresinden ulaşabilirsiniz.

### 3. Frontend (React)
1. Terminal üzerinden `frontend/sehir-rehberi-frontend` klasörüne gidin.
2. `npm install` komutu ile kütüphaneleri yükleyin.
3. `npm run dev` komutu ile arayüzü başlatın.


**Geliştirici:** Emel Ece Gizli  