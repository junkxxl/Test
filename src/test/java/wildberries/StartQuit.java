package wildberries;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.util.Properties;

abstract class StartQuit {
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static Properties config;
    protected WebDriver driver;

    @BeforeAll
    static void loadConfig() throws IOException {
        config = new Properties();
        config.load(StartQuit.class.getClassLoader().getResourceAsStream("config.properties"));
    }


   public static DesiredCapabilities setCapabilities( String browser, String browser_version) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("browser_version", browser_version);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        capabilities.merge(chromeOptions);

        return capabilities;
    }

}
