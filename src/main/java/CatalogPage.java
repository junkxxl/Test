import com.codeborne.selenide.SelenideElement;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class CatalogPage {


    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']/div/div//a")
    SelenideElement elementAddBask;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'Корзина')]")
    SelenideElement elementOpenBask;


    @FindBy(how = How.XPATH, using = "//div[@data-card-index='0']/div/a")
    SelenideElement elementProductHover;


    public CatalogPage selectCategory(String s) {
        String id = saveID();
        $(By.xpath("//label[contains(text(),'" + s + "')]")).shouldBe(visible, enabled).click();
        compareID(id);


        return this;
    }

    public CatalogPage sortSelection(String s) {
        String id = saveID();
        $(By.xpath("//a[@class='sort-item' and contains(. ,'" + s + "')]")).shouldBe(visible, enabled).click();

        compareID(id);

        return this;
    }


    public CatalogPage addBasket() {
        elementProductHover.shouldBe(visible, enabled).hover();
        elementAddBask.shouldBe(visible, enabled).click();

        return this;
    }

    public String saveProductID() {
        elementProductHover.shouldBe(visible, enabled);
        String href = elementProductHover.getAttribute("href");
        String[] artcl = href.split("/");
        return artcl[4];
    }

    public CatalogPage openBasket() {
        elementOpenBask.shouldBe(visible, enabled).click();
        return this;
    }


    public String saveID() {

        return $(By.xpath("//div[@data-card-index='0']")).getAttribute("data-popup-nm-id");

    }

    public void compareID(String id) {

        int count = 0;
        while (id.equals(saveID()) && count < 20) {
            count++;
            if (count == 19)
                Assert.isTrue(id.equals(saveID()), "Error");
        }
    }


}
