package me.junkxxl.testing.kfc;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class MainPage extends BasePageAndroid<MobileDriver<MobileElement>> {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Russia']")
    MobileElement mobileElementCountry;


    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public MainPage countrySelection() {
        mobileElementCountry.click();

        return this;
    }

}
