package me.junkxxl.testing.afisha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExhibitionsPage extends BasePageWeb<WebDriver> {
    protected ExhibitionsPage(WebDriver driver) {
        super(driver);
    }

    public static ExhibitionsPage create(WebDriver driver) {

        return new ExhibitionsPage(driver);
    }

    public ExhibitionsPage clickSelectPoster(String s) {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + s + "']")));
        webElement.click();
        return this;
    }

    public ExhibitionsPage clickOnWeekends() {


        List<WebElement> webElementList = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/button[@data-test='BUTTON HOLIDAY']")));
        webElementList.get(0).click();
        return this;
    }

    public ExhibitionsPage selectExhibition(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/div//span/a[@data-place-link='true' and text()='" + s + "']/../../../../../../../div[1]")));
        webElement.click();
        return this;
    }
}

