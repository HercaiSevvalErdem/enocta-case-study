package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.SearchPage;
import pages.ProductPage;

public class SepeteUrunEklemeSteps {

    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();

    @Given("kullanıcı {string} ve {string} bilgileri ile giriş yapar")
    public void kullanici_giris_yapar(String kullaniciAdi, String sifre) {
        loginPage.girisYap(kullaniciAdi, sifre);
    }

    @When("kullanıcı {string} araması yapar")
    public void kullanici_aramasi_yapar(String aramaKelimesi) {
        searchPage.aramaYap(aramaKelimesi);
    }

    @When("fiyat aralığı olarak {string} ile {string} TL filtrelemesi yapar")
    public void fiyat_araligi_filtrelemesi_yapar(String minFiyat, String maxFiyat) {
        searchPage.fiyatAraligiFiltrele(minFiyat, maxFiyat);
    }

    @When("{string} sıradaki ürünü seçer")
    public void siradaki_urunu_secer(String urunSirasi) {
        searchPage.urunSec(urunSirasi);
    }

    @When("ürün detayında {string} satıcıyı seçer")
    public void urun_detayinda_satici_secer(String saticiStratejisi) {
        productPage.saticiSec(saticiStratejisi);
    }

    @When("ürünü sepete ekler")
    public void urunu_sepete_ekler() {
        productPage.sepeteEkle();
    }

    @Then("ürünün sepete doğru şekilde eklendiği doğrulanır")
    public void urun_sepete_eklendigini_dogrular() {
        boolean eklendiMi = productPage.sepetKontrol();
        if (!eklendiMi) {
            throw new AssertionError("Ürün sepete eklenmedi!");
        }
    }
}
