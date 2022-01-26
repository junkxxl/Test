package me.junkxxl.testing.afisha;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectedConcertPage extends BasePageWeb<WebDriver> {
    protected SelectedConcertPage(WebDriver driver) {
        super(driver);
    }

    public static SelectedConcertPage create(WebDriver driver) {

        return new SelectedConcertPage(driver);
    }

    public SelectedConcertPage selectTicket() {
        driver.switchTo().frame((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='pbySj']"))));

        List<WebElement> webElementList = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button/span")));
        webElementList.get(0).click();

        Assertions.assertNotNull(webElementList.get(0));

        return this;
    }
}
