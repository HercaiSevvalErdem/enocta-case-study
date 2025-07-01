package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.Driver;
import utilities.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        // Eğer senaryo başarısız olduysa ekran görüntüsü al
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot-on-failure");
        }

        // Testten sonra driver'ı kapat
     //   Driver.closeDriver();
    }
}
