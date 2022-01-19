package kfc;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;

public class MapPage extends BasePageAndroid<MobileDriver<MobileElement>> {


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Введите название города']")
    MobileElement mobileElement_EnterNameCity;

    public MapPage(AndroidDriver driver) {
        super(driver);

    }

    public MapPage allowGeolocation() {

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(mobileElement_EnterNameCity));

        return this;
    }
}
