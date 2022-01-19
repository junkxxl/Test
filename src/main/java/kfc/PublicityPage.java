package kfc;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class PublicityPage extends BasePageAndroid<MobileDriver<MobileElement>> {


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ЛОВИ')]")
    private MobileElement mobileElementSwipe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Перейти в меню']")
    private MobileElement mobileElementOpenMenu;


    public PublicityPage(AndroidDriver driver) {
        super(driver);

    }

    public PublicityPage publicityWait() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(mobileElementSwipe));

        return this;
    }

    public PublicityPage clickOpenMenu() {
        mobileElementOpenMenu.click();

        return this;
    }

    public PublicityPage elementOpenMenuWait() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(mobileElementOpenMenu));

        return this;
    }
}
