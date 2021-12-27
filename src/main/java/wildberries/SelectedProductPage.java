package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectedProductPage extends BasePageWeb<WebDriver> {

    public SelectedProductPage(WebDriver driver) {
        super(driver);
    }

    public SelectedProductPage clickProductSize() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".j-size:not(.disabled)")));
        webElement.click();

        return this;
    }

    public SelectedProductPage clickAddBasket() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-main' and contains(@data-link, 'addToBasket ')]")));
        webElement.click();

        return this;
    }

    public SelectedProductPage clickGoToBasket() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Перейти в корзину")));
        webElement.click();

        return this;
    }
}
