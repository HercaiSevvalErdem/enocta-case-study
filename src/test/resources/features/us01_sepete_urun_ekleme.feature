Feature: Sepete ürün ekleme

  Scenario Outline: Kullanıcı farklı ürünleri arar ve sepete ekler
    Given kullanıcı "<kullanici_adi>" ve "<sifre>" bilgileri ile giriş yapar
    When kullanıcı "<arama_terimi>" araması yapar
    And fiyat aralığı olarak "<min_fiyat>" ile "<maks_fiyat>" TL filtrelemesi yapar
    And "<urun_sirasi>" sıradaki ürünü seçer
    And ürün detayında "<satici_stratejisi>" satıcıyı seçer
    And ürünü sepete ekler
    Then ürünün sepete doğru şekilde eklendiği doğrulanır

    Examples:
      | kullanici_adi            | sifre     | arama_terimi | min_fiyat | maks_fiyat | urun_sirasi | satici_stratejisi  |
      | hercaierdem27@gmail.com  | 123Qwe..  | cep telefonu | 15000     | 20000      | en alt      | en dusuk puanli    |
