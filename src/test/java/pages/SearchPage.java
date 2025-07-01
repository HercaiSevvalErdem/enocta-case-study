package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchData")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'searchBtn')]")
    private WebElement searchButton;

    @FindBy(id = "minPrice")
    private WebElement minPriceInput;

    @FindBy(id = "maxPrice")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//button[contains(@class,'priceFilterApply')]")
    private WebElement priceFilterApplyButton;

    @FindBy(xpath = "//div[contains(@class,'catalogView')]//div[contains(@class,'productItem')]")
    private List<WebElement> productList;

    // Arama yap
    public void aramaYap(String aramaKelimesi) {
        searchInput.clear();
        searchInput.sendKeys(aramaKelimesi);
        searchButton.click();
    }

    // Fiyat filtresi uygula
    public void fiyatAraligiFiltrele(String min, String max) {
        minPriceInput.clear();
        minPriceInput.sendKeys(min);
        maxPriceInput.clear();
        maxPriceInput.sendKeys(max);
        priceFilterApplyButton.click();
    }

    // Ürün seçimi (örneğin "en alt" ise son ürünü seç, sayı ise index'e göre)
    public void urunSec(String urunSirasi) {
        int index = 0;
        if (urunSirasi.equalsIgnoreCase("en alt")) {
            index = productList.size() - 1;
        } else {
            try {
                index = Integer.parseInt(urunSirasi) - 1;  // 1 bazlı -> 0 bazlı index
            } catch (NumberFormatException e) {
                index = 0;  // default ilk ürün
            }
        }
        productList.get(index).click();
    }

    public int urunSayisi() {
        return productList.size();
    }
}
