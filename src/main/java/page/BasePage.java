package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.util.function.Function;

public abstract class BasePage<T extends WebDriver> {

    protected final T driver;

    protected BasePage(T driver, Function<T, FieldDecorator> fieldDecoratorProvider) {
        this.driver = driver;
        PageFactory.initElements(fieldDecoratorProvider.apply(driver), this);

    }
}
