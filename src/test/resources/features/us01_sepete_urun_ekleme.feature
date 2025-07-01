Feature: Sepete ürün ekleme

  Scenario Outline: Kullanıcı farklı ürünleri arar ve sepete ekler
    Given kullanıcı "<kullanıcı_adı>" ve "<şifre>" bilgileri ile giriş yapar
    When kullanıcı "<arama_terimi>" araması yapar
    And fiyat aralığı olarak "<min_fiyat>" ile "<maks_fiyat>" TL filtrelemesi yapar
    And "<ürün_sırası>" sıradaki ürünü seçer
    And ürün detayında "<satıcı_stratejisi>" satıcıyı seçer
    And ürünü sepete ekler
    Then ürünün sepete doğru şekilde eklendiği doğrulanır

    Examples:
      | kullanici_adi  | sifre  | arama_terimi   | min_fiyat | maks_fiyat | urun_sirasi | satici_stratejisi     |
      | testkullanici  | 123456 | cep telefonu   | 15000     | 20000      | en alt      | en dusuk puanli       |
      | demoqa         | 654321 | laptop         | 10000     | 17000      | 3           | en ucuz               |
