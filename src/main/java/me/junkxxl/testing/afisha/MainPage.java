package me.junkxxl.testing.afisha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePageWeb<WebDriver> {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static MainPage open(String s, WebDriver driver) {

        driver.get(s);
        return new MainPage(driver);
    }

    public static MainPage create(WebDriver driver) {

        return new MainPage(driver);
    }

    public MainPage clickToExhibitionСategory(String s) {
        WebElement webElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'На сайте')]/../../button[@data-test='BUTTON']")));
        webElement1.click();

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/a[text()='" + s + "']")));
        webElement.sendKeys(Keys.ENTER);

        return this;
    }
}

