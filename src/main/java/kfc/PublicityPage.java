package kfc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PublicityPage {
    private final AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ЛОВИ')]")
    private MobileElement mobileElementSwipe;

    //android.widget.TextView[@text='Перейти в меню']
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Перейти в меню']")
    private MobileElement mobileElementOpenMenu;


    public PublicityPage(AndroidDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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

    public PublicityPage clickOpenMenuWait() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(mobileElementOpenMenu));

        return this;
    }


}
