package me.junkxxl.testing.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductSelectionPage extends BasePageWeb<WebDriver> {

    public ProductSelectionPage(WebDriver driver) {
        super(driver);
    }

    public ProductSelectionPage selectProductSize() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".j-size:not(.disabled)")));
        webElement.click();

        return this;
    }

    public ProductSelectionPage clickAddBasket() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-main' and contains(@data-link, 'addToBasket ')]")));
        webElement.click();

        return this;
    }

    public ProductSelectionPage clickGoToBasket() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Перейти в корзину")));
        webElement.click();

        return this;
    }
}
