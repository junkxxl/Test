package me.junkxxl.testing.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class –°ategoriesPage extends BasePageWeb<WebDriver> {

    public –°ategoriesPage(WebDriver driver) {
        super(driver);
    }

    public –°ategoriesPage selection(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/img[@alt='" + s + "']")));
        webElement.click();

        return this;
    }
}
