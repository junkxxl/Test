package kfc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Russia']")
    MobileElement mobileElementCountry;


    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MainPage countrySelection() {
        mobileElementCountry.click();

        return this;
    }
}
