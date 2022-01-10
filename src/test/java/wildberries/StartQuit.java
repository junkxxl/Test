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

         String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browserstack.local", browserstackLocal);
        capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);

    }

    @AfterEach
    void quit() {
        driver.quit();
    }
}
