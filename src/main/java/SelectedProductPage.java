
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectedProductPage {
    private final WebDriver driver;

    public SelectedProductPage(WebDriver driver) {
        this.driver = driver;
    }


//    @FindBy(how = How.CSS, using = ".j-size:not(.disabled)")
//    SelenideElement elementProductSize;
//
//    @FindBy(how = How.XPATH, using = "//button[@class='btn-main' and contains(@data-link, 'addToBasket ')]")
//    SelenideElement elementAddBasket;
//
//    @FindBy(how = How.LINK_TEXT, using = "Перейти в корзину")
//    SelenideElement elementOpenBasket;
//
//
    public SelectedProductPage clickProductSize() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".j-size:not(.disabled)")));
        webElement.click();


//        elementProductSize.shouldBe(visible).click();
        return this;
    }

    public SelectedProductPage clickAddBasket() {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-main' and contains(@data-link, 'addToBasket ')]")));
        webElement.click();


//        elementAddBasket.shouldBe(visible).click();
        return this;
    }

    public SelectedProductPage clickGoToBasket() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Перейти в корзину")));
        webElement.click();



//        elementOpenBasket.shouldBe(visible).click();
        return this;
    }
}
