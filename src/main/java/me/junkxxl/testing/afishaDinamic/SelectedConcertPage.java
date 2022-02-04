package me.junkxxl.testing.afishaDinamic;

import me.junkxxl.testing.afisha.BasePageWeb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Stream;

import static me.junkxxl.testing.afishaDinamic.ConcertSchedulePage.nameLocation;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SelectedConcertPage extends BasePageWeb<WebDriver> {



    protected SelectedConcertPage(WebDriver driver) {
        super(driver);
    }


    public void compareLocation() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h2")));
        String result = webElement.getText();

        Assertions.assertEquals(nameLocation, result);

        driver.navigate().back();

    }


    Stream<DynamicNode> checkPage() {

        return Stream.of(dynamicContainer("Тест страницы концерта",
                Stream.of(dynamicTest("Проверка локации", () -> compareLocation()))

        ));
    }
}