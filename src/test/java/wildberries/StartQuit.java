package wildberries;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;

abstract class StartQuit {
    protected WebDriver driver;

    @BeforeEach
    void start() throws IOException {
        File app = new File("ru.kfc.kfc_delivery_7.3.0_15944.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<>(
                new URL("http://localhost:4723/wd/hub"),
                capabilities);

    }
    @AfterEach
    void quit() {
        driver.quit();
    }
}
