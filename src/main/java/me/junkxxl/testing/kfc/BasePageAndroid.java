package me.junkxxl.testing.kfc;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import page.BasePage;

public class BasePageAndroid<T extends MobileDriver<MobileElement>> extends BasePage<T> {

    protected BasePageAndroid(T driver) {
        super(driver, AppiumFieldDecorator::new);
    }
}
