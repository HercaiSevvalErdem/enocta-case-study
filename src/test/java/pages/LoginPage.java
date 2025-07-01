package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id= 'email']")  // Kullanıcı adı veya e-posta inputu
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id= 'password']")  // Şifre inputu
    private WebElement passwordInput;

    @FindBy(id = "loginButton")  // Giriş butonu
    private WebElement loginButton;

    public void girisYap(String kullaniciAdi, String sifre) {

        // WebDriverWait ile email inputunun görünmesini bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput));

        // Giriş işlemleri
        emailInput.clear();
        emailInput.sendKeys(kullaniciAdi);

        passwordInput.clear();
        passwordInput.sendKeys(sifre);

        loginButton.click();
    }
}
