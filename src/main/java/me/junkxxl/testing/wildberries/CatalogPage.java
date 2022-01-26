package me.junkxxl.testing.wildberries;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CatalogPage extends BasePageWeb<WebDriver> {


    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']")
    WebElement webElementSaveId;

    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']/div/a")
    WebElement webElement;




    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage selectCategory(String s) {
        String id = saveId();

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + s + "')]")));
        webElement.click();

        compareId(id);

        return this;
    }

    public CatalogPage sortSelection(String s) {
        String id = saveId();
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='sort-item' and contains(. ,'" + s + "')]")));
        webElement.click();

        compareId(id);

        return this;
    }


    public CatalogPage addToBasket() {

        Actions builder = new Actions(driver);
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/a")));
        builder.moveToElement(webElement).build().perform();

        WebElement webElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/div//a")));
        webElement1.click();


        return this;
    }

    public String saveProductId() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/a")));


        String href = webElement.getAttribute("href");
        String[] artcl = href.split("/");
        return artcl[4];
    }

    public CatalogPage openBasket() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Корзина')]")));
        webElement.click();

        return this;
    }

    public String saveId() {
        try{
            WebElement webElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOf(webElementSaveId));

            return webElement.getAttribute("data-popup-nm-id");
        } catch (StaleElementReferenceException e) {
            return saveId();
        }
    }


    public void compareId(String id) {

        int count = 0;
        while (id.equals(saveId()) && count < 20) {
            count++;
            if (count == 19)
                Assertions.assertEquals(id, saveId(), "Error");
        }
    }
}
