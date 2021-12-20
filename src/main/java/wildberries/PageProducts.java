package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PageProducts {
    private final WebDriver driver;
    private By productCard = By.cssSelector(".product-card");

    public PageProducts(WebDriver driver) {
        this.driver = driver;
    }



    String saveID(int i) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> webElementList = driver.findElements(productCard);

//                (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productCard));


        WebElement webElement = webElementList.get(i);
        return webElement.getAttribute("data-popup-nm-id");
    }

    public PageProducts clickToProduct() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(productCard));
        webElement.click();

        return this;
    }
}
