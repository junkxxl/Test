package me.junkxxl.testing.wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import page.BasePage;


public class BasePageWeb<T extends WebDriver> extends BasePage<T> {

    protected BasePageWeb(T driver) {
        super(driver,(d)-> new DefaultFieldDecorator(new DefaultElementLocatorFactory(d)));
    }
}
