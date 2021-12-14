import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    @FindBy(how = How.CSS, using = ".good-info a")
    SelenideElement elementBasket;

    public String saveProductIDBasket() {
        elementBasket.shouldBe(visible, enabled);
        String href = elementBasket.getAttribute("href");
        String[] artcl = href.split("/");

        return artcl[4];
    }


    @FindBy(how = How.CSS, using = ".good-info a")
    ElementsCollection elementsCollection;


    String saveArrayIDBasket(int i) {
        if(!(elementsCollection.size() == 2))
        $(By.xpath("//a[contains(.,'Корзина')]")).shouldBe(visible, enabled).click();

        Assert.isTrue(elementsCollection.size() == 2, "Error");
        SelenideElement se = elementsCollection.get(i);
        se.shouldBe(visible, enabled);
        String href = se.getAttribute("href");
        String[] artcl = href.split("/");




        return artcl[4];
    }

    public void compareIDBasket(String id) {


    }

}
