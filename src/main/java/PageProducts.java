import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;


public class PageProducts {
    @FindBy(how = How.CSS, using = ".product-card")
    ElementsCollection elementsCollection;
    SelenideElement se;




    String saveID(int i) {
        se = elementsCollection.get(i);
        return se.getAttribute("data-popup-nm-id");
    }

    public PageProducts clickToProduct() {
        se.shouldBe(visible).click();
        return this;
    }




}
