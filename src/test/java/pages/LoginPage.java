package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginEmail")  // Örnek: mail veya kullanıcı adı inputu
    private WebElement emailInput;

    @FindBy(id = "loginPassword")  // Şifre inputu
    private WebElement passwordInput;

    @FindBy(id = "loginButton")  // Giriş yap butonu
    private WebElement loginButton;

    public void girisYap(String kullaniciAdi, String sifre) {
        emailInput.clear();
        emailInput.sendKeys(kullaniciAdi);
        passwordInput.clear();
        passwordInput.sendKeys(sifre);
        loginButton.click();
    }
}
