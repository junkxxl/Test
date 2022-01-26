package me.junkxxl.testing.wildberries;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasketPage extends BasePageWeb<WebDriver> {
    private final By goodItem = By.cssSelector(".good-info a");

    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public String saveProductId() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(goodItem));


        String href = webElement.getAttribute("href");
        String[] artcl = href.split("/");

        return artcl[4];
    }

    public String saveArrayId(int i) {


        List<WebElement> webElementList = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodItem));


        if (!(webElementList.size() == 2)) {
            driver.navigate().refresh();
            webElementList = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodItem));

        }
        Assertions.assertEquals(2, webElementList.size(), "Error");

        WebElement webElement1 = webElementList.get(i);

        String href = webElement1.getAttribute("href");
        String[] id = href.split("/");

        return id[4];
    }
}
