package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProductsPage extends BasePageWeb<WebDriver> {

    private final By productCard = By.cssSelector(".product-card");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    String saveid(int i) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> webElementList = driver.findElements(productCard);


        WebElement webElement = webElementList.get(i);
        return webElement.getAttribute("data-popup-nm-id");
    }

    public ProductsPage clickToProduct(String product) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-popup-nm-id='" + product + "']")));
        webElement.click();

        return this;
    }
}
