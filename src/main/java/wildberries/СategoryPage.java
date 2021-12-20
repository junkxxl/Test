package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class СategoryPage {

    private final WebDriver driver;

    public СategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public СategoryPage selection(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/img[@alt='" + s + "']")));
        webElement.click();

//        $(By.xpath("//div/img[@alt='" + s + "']")).shouldBe(visible,enabled).click();

        return this;
    }
}
