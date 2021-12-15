
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class CatalogPage {
    private final WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //
//    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']/div/div//a")
//    SelenideElement elementAddBask;
//
//    @FindBy(how = How.XPATH, using = "//a[contains(.,'Корзина')]")
//    SelenideElement elementOpenBask;
//
//
//    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']/div/a")
//    SelenideElement elementProductHover;
//
//
    public CatalogPage selectCategory(String s) {
        String id = saveID();

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + s + "')]")));
        webElement.click();

//        $(By.xpath("//label[contains(text(),'" + s + "')]")).shouldBe(visible, enabled).click();
        compareID(id);


        return this;
    }

    public CatalogPage sortSelection(String s) {
        String id = saveID();
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='sort-item' and contains(. ,'" + s + "')]")));
        webElement.click();

//        $(By.xpath("//a[@class='sort-item' and contains(. ,'" + s + "')]")).shouldBe(visible, enabled).click();

        compareID(id);

        return this;
    }


    public CatalogPage addBasket() {

        Actions builder = new Actions(driver);
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/a")));
        builder.moveToElement(webElement).build().perform();

        WebElement webElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/div//a")));
        webElement1.click();


//        elementProductHover.shouldBe(visible, enabled).hover();
//        elementAddBask.shouldBe(visible, enabled).click();

        return this;
    }

    public String saveProductID() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-card-index='0']/div/a")));

//        elementProductHover.shouldBe(visible, enabled);
        String href = webElement.getAttribute("href");
        String[] artcl = href.split("/");
        return artcl[4];
    }

    public CatalogPage openBasket() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Корзина')]")));
        webElement.click();

//        elementOpenBask.shouldBe(visible, enabled).click();
        return this;
    }

    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']")
    WebElement webElementSaveID;

    public String saveID() {
        try{
            WebElement webElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOf(webElementSaveID));

//        $(By.xpath("//div[@data-card-index='0']")).getAttribute("data-popup-nm-id");

            return webElement.getAttribute("data-popup-nm-id");
        } catch (StaleElementReferenceException e) {
            return saveID();
        }
    }

    //
    public void compareID(String id) {

        int count = 0;
        while (id.equals(saveID()) && count < 20) {
            count++;
            if (count == 19)
                Assert.isTrue(id.equals(saveID()), "Error");
        }
    }


}
