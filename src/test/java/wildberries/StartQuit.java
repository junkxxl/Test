package wildberries;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

abstract class StartQuit {
    static Properties config;
    protected WebDriver driver;

    @BeforeAll
    static void loadConfig() throws IOException {
        config = new Properties();
        config.load(StartQuit.class.getClassLoader().getResourceAsStream("config.properties"));

    }

    @BeforeEach
    void start() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.merge(options);

        driver = new RemoteWebDriver(new URL(config.getProperty("webdriver.url")), capabilities);


    }

    @AfterEach
    void quit() {
        driver.quit();
    }
}
