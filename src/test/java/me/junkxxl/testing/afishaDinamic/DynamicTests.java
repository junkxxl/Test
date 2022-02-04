package me.junkxxl.testing.afishaDinamic;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTests {
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"),
            new ChromeOptions().addArguments("--start-maximized"));


    public DynamicTests() throws MalformedURLException {

    }


    @TestFactory
    Stream<DynamicNode> afishaTest() throws MalformedURLException {
        DynamicTest quit = dynamicTest("quit", () -> driver.quit());

        return Stream.of(
                new MainPage(driver).checkPage(),
                Stream.of(quit)).flatMap(s -> s);
    }
}
