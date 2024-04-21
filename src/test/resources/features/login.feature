@LoginPage
Feature: Kullanici Giris Senaryosu

  @HappyPathLoginScenario
  Scenario: Check login page
    Given Hepsiburada mobil uygulamasi acilir
    When Hesabim butonuna tiklanir
    When Sayfa basligi "Misafir kullanıcı" oldugu dogrulanir
    When "Giriş yap" butonuna basilir
    Then Eposta inputuna tiklanir ve "validTestUser" girilir
    When Sifre alanina tiklanir ve "validTestUserPass" girilir
    When "Giriş yap" butonuna basilir
    When "TAMAM" butonuna basilir
    Then Kullanici "isim-soyisim" bilgisi dogrulanir
