@SearchPage @SearchPageResult
Feature: Urun aratma

  @UrunArama @UrunDetaySayfasi
  Scenario: Belirli bir urun aratma ve Urun Detay sayfasinin kontrolu
    Given Hepsiburada mobil uygulamasi acilir
    When Tum kategoriler butonuna tiklanir
    When Search bar tiklanir ve "Lenovo" keywordu aratilir
    When Fiyat araligi filtresine tiklanir
    When Min 8000 Maks 20000 fiyat araligi uygulanir
    When Listelenen urunlerden birinin detayina gidilir
    When "Sepete ekle" textview kontrol edilir