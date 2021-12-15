import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

abstract class StartQuit {
    protected WebDriver driver;

    @BeforeEach
    void start() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

    }
    @AfterEach
    void quit() {
        driver.quit();
    }
}
