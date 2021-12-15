
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasketPage {
    private final WebDriver driver;
    private By goodItem = By.cssSelector(".good-info a");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }


//    @FindBy(how = How.CSS, using = ".good-info a")
//    SelenideElement elementBasket;
//
    public String saveProductIDBasket() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(goodItem));



//        elementBasket.shouldBe(visible, enabled);
        String href = webElement.getAttribute("href");
        String[] artcl = href.split("/");

        return artcl[4];
    }
//
//
//    @FindBy(how = How.CSS, using = ".good-info a")
//    ElementsCollection elementsCollection;
//
//
    String saveArrayIDBasket(int i) {


        List<WebElement> webElementList = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodItem));


        if(!(webElementList.size() == 2)) {
            driver.navigate().refresh();
            webElementList = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodItem));


//            $(By.xpath("//a[contains(.,'Корзина')]")).shouldBe(visible, enabled).click();
        }
        Assert.isTrue(webElementList.size() == 2, "Error");


        WebElement webElement1 = webElementList.get(i);


        String href = webElement1.getAttribute("href");
        String[] artcl = href.split("/");




        return artcl[4];
    }
//
//    public void compareIDBasket(String id) {
////
//
//    }

}
