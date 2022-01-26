package me.junkxxl.testing.calculator;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

abstract class StartQuit {
    static Config config;
    protected WindowsDriver driver;

    @BeforeAll
    static void loadConfig() throws IOException {
        config = ConfigFactory.load();

    }


    @BeforeEach
    void start() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        driver = new WindowsDriver<WindowsElement>(new URL(config.getString("url.windowsDriver")), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    String getResult() {

        return driver.findElementByAccessibilityId("CalculatorResults").getText().split(" ")[2];
    }

}
