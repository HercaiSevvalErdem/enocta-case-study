package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='searchData']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@id='minPrice']")
    private WebElement minPriceInput;

    @FindBy(id = "maxPrice")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//span[@id='priceSearchButton']")
    private WebElement priceButton;


    @FindBy(xpath = "//div[contains(@class,'catalogView')]//div[contains(@class,'productItem')]")
    private List<WebElement> productList;

    public void aramaYap(String aramaKelimesi) {
        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        actions.moveToElement(searchInput).click().perform();
        searchInput.sendKeys(aramaKelimesi);

// Kutucuğa bir kez tıklama işlemi:
        actions.moveToElement(searchInput).click().perform();

// Enter tuşuna basma işlemi:
        searchInput.sendKeys(Keys.ENTER);


        //  minPrice elementinin gelmesini bekleyebiliriz
        wait.until(ExpectedConditions.elementToBeClickable(minPriceInput));
    }

    public void fiyatAraligiFiltrele(String min, String max) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(minPriceInput));
        minPriceInput.clear();
        minPriceInput.sendKeys(min);
        maxPriceInput.clear();
        maxPriceInput.sendKeys(max);
    }

    public void urunSec(String urunSirasi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));

        int index = 0;
        if (urunSirasi.equalsIgnoreCase("en alt")) {
            index = productList.size() - 1;
        } else {
            try {
                index = Integer.parseInt(urunSirasi) - 1;
            } catch (NumberFormatException e) {
                index = 0;
            }
        }

        if (index >= 0 && index < productList.size()) {
            productList.get(index).click();
        } else {
            throw new RuntimeException("Belirtilen sıra geçerli değil: " + urunSirasi);
        }
    }

    public int urunSayisi() {
        return productList.size();
    }
}
