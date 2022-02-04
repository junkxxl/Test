package me.junkxxl.testing.afisha;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


abstract class StartQuit {

    protected WebDriver driver;

    @Before
    public void start() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions().addArguments("--start-maximized"));

    }

    @After
    public void quit() {
        driver.quit();
    }
}
