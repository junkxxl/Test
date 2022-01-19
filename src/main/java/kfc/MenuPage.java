package kfc;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;


public class MenuPage extends BasePageAndroid<MobileDriver<MobileElement>> {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Добавить в корзину']")
    private MobileElement mobileElementAddBasket;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='КОРЗИНА']")
    private MobileElement mobileElementOpenBasket;


    public MenuPage(AndroidDriver driver) {
        super(driver);
    }


    public MenuPage selectProduct(String product) {

        MobileElement mobileElementSelectCategories = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".setAsVerticalList().scrollIntoView(new UiSelector().text(\"" + product + "\"))"));

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(mobileElementSelectCategories));


        MobileElement mobileElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + product + "')]/../android.view.ViewGroup[@index='3']"));

        mobileElement.click();

        return this;
    }

    public MenuPage addBasket() {
        mobileElementAddBasket.click();

        return this;
    }

    public MenuPage openBasket() {
        mobileElementOpenBasket.click();

        return this;
    }

    public String saveNameProductFromBasket(String nameProduct) {
        MobileElement mobileElementSaveProductIDBasket = driver.findElement(By.xpath("//android.widget.TextView[@text='" + nameProduct + "' and @index='0']"));

        return mobileElementSaveProductIDBasket.getText();
    }
}