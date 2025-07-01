package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductPage {

    WebDriver driver;

    public ProductPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'sellers-list')]//div[contains(@class,'seller-item')]")
    private List<WebElement> sellersList;

    @FindBy(xpath = "//div[contains(@class,'seller-score')]")
    private List<WebElement> sellersScoreList;

    @FindBy(xpath = "//button[contains(text(),'Sepete Ekle') or contains(@class,'add-to-cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]")
    private List<WebElement> cartItems;

    // Satıcı seçimi: "en dusuk puanli" veya "en ucuz"
    public void saticiSec(String strateji) {
        WebElement selectedSeller = null;

        if (strateji.equalsIgnoreCase("en dusuk puanli")) {
            double minScore = Double.MAX_VALUE;
            int selectedIndex = -1;

            for (int i = 0; i < sellersScoreList.size(); i++) {
                String text = sellersScoreList.get(i).getText().replace(",", ".");
                try {
                    double score = Double.parseDouble(text);
                    if (score < minScore) {
                        minScore = score;
                        selectedIndex = i;
                    }
                } catch (NumberFormatException e) {
                    // parse hatası
                }
            }

            if (selectedIndex != -1) {
                selectedSeller = sellersList.get(selectedIndex);
                selectedSeller.click();
            }

        } else if (strateji.equalsIgnoreCase("en ucuz")) {
            // En ucuz satıcı seçimi için fiyat locators ve logic eklenmeli
        }
    }

    // Sepete ekle
    public void sepeteEkle() {
        addToCartButton.click();
    }

    // Sepet kontrolü
    public boolean sepetKontrol() {
        return cartItems.size() > 0;
    }
}
