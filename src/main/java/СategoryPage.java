import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class СategoryPage {


    public СategoryPage selection(String s) {
        $(By.xpath("//div/img[@alt='" + s + "']")).shouldBe(visible,enabled).click();

        return this;
    }
}
