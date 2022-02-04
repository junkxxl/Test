package me.junkxxl.testing.afisha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ConcertPage extends BasePageWeb<WebDriver> {


    protected ConcertPage(WebDriver driver) {
        super(driver);
    }

    public static ConcertPage create(WebDriver driver) {

        return new ConcertPage(driver);
    }

    public ConcertPage selectGenre(String s) {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()='" + s + "']")));
        webElement.click();
        return this;
    }

    public ConcertPage selectSort(String s) {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[text()='" + s + "']")));
        webElement.click();
        return this;
    }

    public ConcertPage selectConcert() {

        List<WebElement> webElementList = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@data-test='LIST']//div[@data-test='ITEM']/div[1]")));
//
        webElementList.get(0).click();

        return this;
    }
}