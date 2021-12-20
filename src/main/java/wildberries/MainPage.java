package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public static MainPage open(String s, WebDriver driver) {

        driver.get(s);
        MainPage page = new MainPage(driver);
        PageFactory.initElements(driver, page);
        return page;
    }


    public MainPage search(String value) {
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys(value);
        searchInput.sendKeys(Keys.ENTER);

        return this;
    }




    public MainPage openCatalogsButton() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".nav-element__burger")));
        webElement.click();


        return this;
    }




    public MainPage catalogSelection(String s) throws InterruptedException {
        Actions builder = new Actions(driver);

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu-burger__main-list']//a[text()='" + s + "']")));
        builder.moveToElement(webElement).build().perform();


//        $(By.xpath("//ul[@class='menu-burger__main-list']//a[text()='" + s + "']")).shouldBe(visible, enabled).hover();
        return this;
    }

    public MainPage openAllCategories(String categories, String s) throws InterruptedException {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + categories + "']/..//a[text()='" + s + "']")));
        webElement.click();

        return this;
    }

    public MainPage categorySelection(String categories) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + categories + "']")));
        webElement.click();
//        $(By.xpath("//a[text()='" + categories + "']")).shouldBe(visible, enabled).click();
        return this;
    }
}
