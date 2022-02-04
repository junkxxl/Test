package me.junkxxl.testing.afisha;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectedExhibitionPage extends BasePageWeb<WebDriver> {


    protected SelectedExhibitionPage(WebDriver driver) {
        super(driver);
    }

    public static SelectedExhibitionPage create(WebDriver driver) {

        return new SelectedExhibitionPage(driver);
    }

    public SelectedExhibitionPage compareLocation(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + s + "']")));

        String location = webElement.getText();
        Assertions.assertEquals(s, location);

        return this;
    }

    public SelectedExhibitionPage clickExhibitionСategory(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/a[text()='" + s + "']")));
        webElement.sendKeys(Keys.ENTER);

        return this;
    }
}