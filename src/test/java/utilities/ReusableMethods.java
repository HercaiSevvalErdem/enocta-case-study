package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {

    public static void getScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(source, new File(filePath));
            System.out.println("✔ Ekran görüntüsü kaydedildi: " + filePath);
        } catch (IOException e) {
            System.out.println("✘ Ekran görüntüsü alınamadı: " + e.getMessage());
        }
    }
}
